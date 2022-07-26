package string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Encoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
// создать строчку с русским текстом в кодировке win-1251, распечатать побайтово
        String source = "Привет";
        byte[] bytes = source.getBytes("cp1251");
        for (Byte b : bytes) {
            System.out.print(b + ", ");
        }
        System.out.println();

// конвертировать эту строчку в utf-8, распечатать побайтово
        bytes = source.getBytes(StandardCharsets.UTF_8);
        for (Byte b : bytes) {
            System.out.print(b + ", ");
        }
        System.out.println();
// конвертировать эту строчку в utf-16, распечатать побайтово
        bytes = source.getBytes(StandardCharsets.UTF_16);
        for (Byte b : bytes) {
            System.out.print(b + ", ");
        }
    }
}
