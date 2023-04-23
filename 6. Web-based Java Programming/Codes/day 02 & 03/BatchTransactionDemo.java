/**
 * Batch processing and Transaction management
 */
package jdbcapp;

import java.sql.*;
import java.util.Scanner;

public class BatchTransactionDemo {

    public static void main(String[] args) throws Exception {

        // connect
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if (con != null) {
            System.out.println("Connection established");
        }

        // disabling MySQL's autocommit
        con.setAutoCommit(false);

        // get input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source cid");
        int srcId = scanner.nextInt();
        System.out.println("Enter destination cid");
        int dstId = scanner.nextInt();
        System.out.println("How much amount you want to transfer?");
        double amt = scanner.nextDouble();

        // create Statement
        Statement stmt = con.createStatement();

        // the queries
        String q1 = "update customers set balance = balance - " + amt + " where cid = " + srcId;
        String q2 = "update customers set balance = balance + " + amt + " where cid = " + dstId;

        /*  batch processing    */
        // add queries to batch
        stmt.addBatch(q1);
        stmt.addBatch(q2);

        // execute batch, returns int[]
        int[] arr = stmt.executeBatch();

        /*  transaction management, whether to commit or rollback  */
        boolean flag = false;
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) { // if a transaction is failed, "0 rows updated kinda thing"
                flag = true;
                break;
            }
        }

        if (flag == true) {
            con.rollback();
            System.out.println("Transaction rolled back!");
        } else {
            con.commit();
            System.out.println("Transaction committed!");
        }
    }
}
