package arithmetic.utils;

import arithmetic.constant.SymbolConstant;

/**
 * @author liyusheng
 * @date 2020/10/8
 * 运算操作工具类
 */
public class OperatorUtil {

    private final static Character[] operatorTypes = new Character[]{SymbolConstant.PLUS,SymbolConstant.MINUS,SymbolConstant.MULTIPLY,SymbolConstant.DIVIDE};

    /**
     * 随机获取num个运算符的数组
     */
    static Character[] getOperators(int num) {

        Character[] operators = new Character[num];

        for (int i = 0; i < num; i++) {
            //随机获取运算符的类型(0~3 代表4个运算符的类型)
            int operatorTypeIndex = (int)(Math.random()*4);
            Character operatorType = operatorTypes[operatorTypeIndex];
            operators[i] = operatorType;
        }

        return operators;
    }


}
