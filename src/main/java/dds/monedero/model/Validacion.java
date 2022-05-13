package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

public class Validacion {

  public static void montoNegativo(double monto) {
    if (monto <= 0) {
      throw new MontoNegativoException(monto + ": el monto a ingresar debe ser un valor positivo");
    }
  }

  public static void maximaCantidadDepositos(long cantidad) {
    if (cantidad >= 3) {
      throw new MaximaCantidadDepositosException("Ya excedio los " + 3 + " depositos diarios");
    }
  }

  public static void saldoMenor(double monto, double saldo) {
    if(saldo < monto) {
      throw new SaldoMenorException("No puede sacar mas de " + saldo + " $");
    }
  }

  public static void maximoExtraccionDiario(double monto, double limite) {
    if (monto > limite) {
      throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + 1000
          + " diarios, límite: " + limite);
    }
  }
}
