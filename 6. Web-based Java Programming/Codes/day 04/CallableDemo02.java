/**
 *Calling a stored procedure using CallableStatement interface
 *
 * use registerOutParameter() to register the OUT parameters first,
 * then use get method to retrieve the output
 *
 * Procedure used:
 *
 * DELIMITER $$
 * CREATE PROCEDURE getBalance(IN id INT, OUT bal FLOAT)
 * BEGIN
 *      SELECT balance INTO bal FROM customers WHERE cid = id;
 * END $$
 * DELIMITER ;
 */
package jdbcapp;

import java.sql.*;

public class CallableDemo02 {

    public static void main(String[] args) throws Exception {
        //connect
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if (con != null) {
            System.out.println("Connected to DB");
        }

        String str1 = "{ CALL getBalance(?,?) }";

        CallableStatement cst = con.prepareCall(str1);

        // IN parameter
        cst.setInt(1, 888);

        // OUT parameter
        // Step1: Register out parameter
        // Syntax: registerOutParameter(<parameter_number>, <Datatype of OUT parameter using java.sql.Types>)
        cst.registerOutParameter(2, java.sql.Types.FLOAT);

        // Step2: execute query
        cst.executeQuery();

        // Step3: use get method to retirve the output
        double balance = cst.getDouble(2);

        System.out.println(balance);

        cst.close();
        con.close();
    }
}
