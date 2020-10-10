package arithmetic;

import arithmetic.utils.ExpressionUtil;
import arithmetic.utils.PrintFileUtil;
import arithmetic.utils.ValidateUtil;

import java.util.Map;
import java.util.Scanner;

/**
 * @author liyusheng
 * @date 2020/10/8
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("****************************欢迎使用四则运算题目生成程序*****************************");
        System.out.println("****使用-n 参数控制题目生成数目 -r 参数控制题目中数值（自然数、真分数和真分数分母）的范围*****");
        System.out.println("**********使用 -e <exercisefile>.txt -a <answerfile>.txt 检查答案的正确率**********");

        while(true){

            //获得输入命令
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("bye")){
                break;
            }
            String[] split = ValidateUtil.checkParams(command);//先校验输入避免出现不可靠输入导致程序退出
            if (split!=null){
                //判断是否为题目生成需求
                if (split[0].equals("-n")) {
                    //生成题目数量
                    int num = Integer.valueOf(split[1]);
                    if (num <= 0) {
                        System.out.println("-n参数需为正数，请重新输入");
                    }else {
                        //题目中数值
                        int round = Integer.valueOf(split[3]);
                        if (round <= 0) {
                            System.out.println("-r参数需为正数，请重新输入");
                        } else {
                            //获取运算式数组
                            System.out.println("正在生成题目～(￣▽￣～)~");
                            Map<String, String> questionAndResultMap = ExpressionUtil.generate(num, round);
                            //生成题目在Map中
                            System.out.println("生成完成，请等待✺◟(∗❛ัᴗ❛ั∗)◞✺");
                            PrintFileUtil .printExerciseFileAndAnswerFile(questionAndResultMap);
                            //输出题目答案到指定文件中
                        }
                    }
                }else {//输入的是答案检查需求
                    String exerciseFileUrl = split[1];
                    String answerFileUrl = split[3];
                    //验证答案，并返回答案的错误条数
                    PrintFileUtil.validateAnswerFile(exerciseFileUrl, answerFileUrl);
                }
            }else {
                System.out.println("参数输入有误，请重新输入");
            }

        }
    }

}
