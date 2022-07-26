package string;

import java.util.Random;

public class Test {


    public static String appendUsingStringBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(new Random().nextInt(9));
        }
        return stringBuffer.toString();
    }
    public static String appendUsingStringBuilder(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(new Random().nextInt(9));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
// создать String путем сложения рандомных символов от 0 до 9 типа "0410311293"
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            result += random.nextInt(9);
        }
        System.out.println(result);

// используя StringBuffer
        String result2 = appendUsingStringBuffer();
        System.out.println(result2);

// используя StringBuilder
        String result3 = appendUsingStringBuilder();
        System.out.println(result3);

// создать зеркальную копию строки
        String reverse = "";
        for (int i = 0; i < result.length() ; i++) {
            reverse = result.charAt(i) + reverse;
        }
        System.out.println(reverse);

// создать из строки полином
        String polinom = reverse + result;
        System.out.println(polinom);

// сравнить 2 строки
        String word1 = "abx";
        String word2 = "abc";
        System.out.println(word1.equals(word2));
        System.out.println(word1 == word2);

        String t1 = "test";
        String t2 = "t"+"e"+"s"+(1==1?'t':'z');
        System.out.println(t1==t2);
//        boolean equals = true;
//        if (word1.length() == word2.length()) {
//            for (int i = 0; i <= word1.length() - 1 ; i++) {
//               if (word1.charAt(i) != word2.charAt(i)) {
//                   equals = false;
//                   System.out.println("не равны");
//                   break;
//               }
//            }
//            if (equals) {
//                System.out.println("строки равны");
//            }
//        } else {
//            System.out.println("не равны");
//        }

        // конвертировать String в массив byte - byte[]
        byte[] bytes = result.getBytes();
        for (byte b : bytes){
            System.out.print(b);
        }
    }
}
