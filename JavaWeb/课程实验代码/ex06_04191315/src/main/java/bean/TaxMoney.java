package bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @ClassName taxMoney
 * @description: TODO
 * @author: 何翔
 * @Date 2021/4/7 11:32
 */

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxMoney {
    private double money;
    private double dr=0;

    @Override
    public String toString() {
        return "taxMoney{" +
                "money=" + money +
                '}';
    }
}
