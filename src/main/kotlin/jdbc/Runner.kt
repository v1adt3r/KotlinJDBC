package jdbc

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement

fun main() {
    //Class.forName("com.mysql.jdbc.Driver")

    val connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC",
        "root",
        "root"
    )

    val updateStmt = connection.prepareStatement("update salespeople set comm=20 where snum=1010")
    updateStmt.executeUpdate()

    /*
    val stmt: PreparedStatement =
        connection.prepareStatement("insert into salespeople (snum, sname, city, comm) values (?, ?, ?, ?)")
    stmt.setInt(1, 1010)
    stmt.setString(2, "Ivanov")
    stmt.setString(3, "Moscow")
    stmt.setInt(4, 14)
    stmt.executeUpdate()
    */
    /*
    val stmt: Statement = connection.createStatement()

    val result = stmt.executeQuery("select * from salespeople")

    while(result.next()) {
        val string = "${result.getInt(1)} ${result.getString(2)} ${result.getString(3)}"

        println(string)
    }
    */
}