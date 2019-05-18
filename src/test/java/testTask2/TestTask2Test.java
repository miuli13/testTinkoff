package testTask2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.*;

import static org.junit.Assert.*;


public class TestTask2Test {

    @Test
    public void columnExists() throws IOException {
        File file = new File("columnExists.txt");
        String separator = ";";
        String columnToChange = "column2";
        String oldValue = "value2";
        String in = "column1" + separator + columnToChange + "\nvalue1" + separator + oldValue;
        String newValue = "value3";

        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = in.getBytes();
        fos.write(buffer, 0, buffer.length);

        TestTask2 testTask2 = new TestTask2(file, separator);
        testTask2.changeValue(columnToChange, newValue);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        line = line.concat("\n").concat(bufferedReader.readLine());

        assertEquals(in.replace(oldValue, newValue), line);
    }

    @Test
    public void columnNotExists() throws IOException {
        File file = new File("columnNotExists.txt");
        String separator = " ";
        String oldValue = "value2";
        String in = "column1" + separator + "column2" + "\nvalue1" + separator + oldValue;
        String newValue = "value3";

        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = in.getBytes();
        fos.write(buffer, 0, buffer.length);

        TestTask2 testTask2 = new TestTask2(file, separator);
        testTask2.changeValue("column3", newValue);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        line = line.concat("\n").concat(bufferedReader.readLine());

        assertEquals(in, line);
    }

    @Test
    public void emptyFile() {
        File file = new File("emptyFile.txt");
        String newValue = "value3";

        TestTask2 testTask2 = new TestTask2(file, " ");

        Throwable thrown = catchThrowable(() -> testTask2.changeValue("column3", newValue));
        assertThat(thrown).isInstanceOf(FileNotFoundException.class);

    }

    @Test
    public void valueNotExists() throws IOException {
        File file = new File("valueNotExists.txt");
        String separator = ";";
        String columnToChange = "column2";
        String in = "column1" + separator + columnToChange + "\nvalue1";
        String newValue = "value3";

        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = in.getBytes();
        fos.write(buffer, 0, buffer.length);

        TestTask2 testTask2 = new TestTask2(file, separator);
        testTask2.changeValue(columnToChange, newValue);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        line = line.concat("\n").concat(bufferedReader.readLine());

        assertEquals(in, line);
    }

}