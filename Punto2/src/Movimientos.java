import java.sql.*;
public class Movimientos {
    public static void depositarCuenta(Connection con, int cuenta, double dinero) throws SQLException {
		String updateAccount = "UPDATE cuentas SET saldo = saldo + ? where cuenta = ?";
		String insertMovement = "INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES (?, 'D', ?)";
        PreparedStatement update = null; 
        PreparedStatement insert = null; 

		try {

			update = con.prepareStatement(updateAccount);
			update.setDouble(1, dinero);
            update.setInt(2, cuenta);

            int filasModificadas = update.executeUpdate();
            if(filasModificadas == 0){
                System.out.println("La cuenta a la que desea depositar no existe");
                throw new SQLException();
            }
            insert = con.prepareStatement(insertMovement);
            insert.setInt(1, cuenta);
            insert.setDouble(2, dinero);
			insert.executeUpdate();
			con.commit();
			System.out.println("Deposito realizado correctamente.");
		} catch (SQLException e) {
                con.rollback();
		} finally {
			if (update != null)
				update.close();
            if(insert != null)
                insert.close();
		}
	}
	

    public static void extraerCuenta(Connection con, int cuenta, double dinero) throws SQLException {
        String selectSaldo = "SELECT saldo FROM cuentas WHERE cuenta = ? FOR UPDATE";
		String updateAccount = "UPDATE cuentas SET saldo = saldo - ? where cuenta = ?";
		String insertMovement = "INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES (?, 'E', ?)";
        PreparedStatement select = null;
        ResultSet rs = null;
        PreparedStatement update = null; 
        PreparedStatement insert = null;
        double saldo = -1;

		try {
            select = con.prepareStatement(selectSaldo);
            select.setInt(1, cuenta);
            rs = select.executeQuery();
            if(rs.next()){
                saldo = rs.getDouble("saldo");
            }else{
                System.out.println("La cuenta a la que desea depositar no existe");
                throw new SQLException();
            }

            if(dinero <= saldo){
                update = con.prepareStatement(updateAccount);
                update.setDouble(1, dinero);
                update.setInt(2, cuenta);
                
                update.executeUpdate();

                insert = con.prepareStatement(insertMovement);
                insert.setInt(1, cuenta);
                insert.setDouble(2, dinero);

                insert.executeUpdate();
                con.commit();
                System.out.println("Extraccion realizada correctamente.");
            }
            else{
                System.out.println("No se puede realizar la extraccion porque el dinero que quiere extraer (" + dinero + ") es mayor a la cantidad que hay en la cuenta (" + saldo + ").");
                throw new SQLException();
            }
		} catch (SQLException e) {
                con.rollback();
		} finally {
            if(select != null)
                select.close();
			if (update != null)
				update.close();
            if(insert != null)
                insert.close();
		}
	}
	
}
