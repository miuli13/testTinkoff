package testTask2;

import java.io.*;

class TestTask2 {
    private File file;
    final private String separator;

    /**
     * При создании класса необходимо на вход подать файл и разделитель
     */
    TestTask2(final File file, final String separator) {
        this.file = file;
        this.separator = separator;
    }

    void changeValue(String columnName, String newValue) throws IOException {
        if (file.exists()) {
            String[] keysAndValues = readKeysAndValues(file);
            String[] keys = keysAndValues[0].split(separator);
            String[] values = keysAndValues[1].split(separator);
            String newValues = "";

            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equals(columnName)) {
                    if (i < values.length) values[i] = newValue;
                }
            }

            for (int i = 0; i < values.length; i++) {
                newValues = newValues.concat(values[i]);
                if (i != values.length - 1) newValues = newValues.concat(separator);
            }

            writeToFile(keysAndValues[0].concat("\n").concat(newValues));
        } else {
            throw new FileNotFoundException();
        }
    }


    private String[] readKeysAndValues(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        return new String[]{bufferedReader.readLine(), bufferedReader.readLine()};
    }

    private void writeToFile(String stringToWrite) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = stringToWrite.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
