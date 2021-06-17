package ex04;

/*
 * @ClassName Student
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/25 0:41
 */

import lombok.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String s_id;
    String s_name;
    String academy;
    String specialize_course;

    public boolean isExistStudent(Student stu){
        /*
         * @author: 何翔
         * @param: [classId, stu_id, name]
         * @return: boolean
         * @date: 2020/11/20 9:35
         * @description：判断学生是否存在
         */
        String sql = "select * from s_student where s_id=? and s_name=? and s_college=? and s_course=?";
        try {
            PreparedStatement preparedStatement = new JDBCUtil().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, stu.s_id);
            preparedStatement.setString(2, stu.s_name);
            preparedStatement.setString(3, stu.academy);
            preparedStatement.setString(4, stu.specialize_course);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()){
                return true;
            }
        } catch (SQLException ignored) { }
        return false;
    }
}
