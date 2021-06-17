package dao.impl;


import dao.BaseDao;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email`,`phone` from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`phone` from t_user where username = ? and password =" +
                " ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`,`phone`) values(?,?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone());
    }

    public boolean judgeInfo(User user1,User user2){
        return user1.getUsername().equals(user2.getUsername())&&user1.getPassword().equals(user2.getPassword());
    }

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username) {
        // 等于null,说明没查到，没查到表示可用
        return this.queryUserByUsername(username) == null;
    }
}
