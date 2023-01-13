package hackerrank.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import org.apache.

public class RunningScript {
    public static void main(String[] args) {
        RunningScript runningScript = new RunningScript();
        runningScript.runDbScript();
    }
    Connection connection;

    public void runDbScript() {
        try {
            connection = DbUtil.getConnection();
            ScriptFile scriptFile = new ScriptFile();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbUtil.closeConnection(connection);
        }
    }
}

class ScriptFile {
    public void executeSqlScript(Connection connection)  {
        File inputFile = new File("/home/dieguinho/Documents/projects/tata/SimpleJavaProject/db.sql");
        // Delimiter
        String delimiter = ";";

        Scanner scanner;
        try {
            scanner = new Scanner(inputFile).useDelimiter(delimiter);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }

        // Loop through the SQL file statements
        Statement currentStatement = null;
        while(scanner.hasNext()) {

            // Get statement
            String rawStatement = scanner.next() + delimiter;
            try {
                // Execute statement
                currentStatement = connection.createStatement();
                currentStatement.execute(rawStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Release resources
                if (currentStatement != null) {
                    try {
                        currentStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                currentStatement = null;
            }
        }
        scanner.close();
    }
}
