package unidat3.colas;

import javax.swing.table.DefaultTableModel;

public class colaPedidos {
    private Pedidos cola[];
    private int fin, frente, max;

    public colaPedidos() {
        max = 20;
        frente = 0;
        fin = 0;
        cola = new Pedidos[max];
    }

    private boolean colaLlena() {
        return fin==max;
    }
    private boolean colaVacia() {
        return fin==0;
    }
    public  String insertarEnCola(Pedidos nuevo_pedido) {
        if(!colaLlena()) {
            cola[fin++]=nuevo_pedido;
            return "Insertado con exito";
        } else {
            return "Cola llena";
        }
    }
    public String eliminarDeCola() {
        if(!colaVacia()) {
            for(int i = 1; i < fin; i++) {
                cola[i-1] = cola[i];
            }
            cola[--fin]=null;
            return "Elemento eliminado";
        } else {
            return "Cola Vacia";
        }
    }
    public DefaultTableModel reporteGeneral(boolean orden) {
        DefaultTableModel dtm = new DefaultTableModel();
        Object datos[] = new Object[5];
        dtm.addColumn("NOMBRE");
        dtm.addColumn("N PEDIDO");
        dtm.addColumn("ORDEN");
        dtm.addColumn("TOTAL");
        int inicio = orden? 0: fin-1;
        int dir = orden? 1:-1;
        for(int i = inicio; orden? i < fin : i >= 0; i+=dir) {
            cola[i].calcularTotal();
            datos[0] = cola[i].getNombreCliente();
            datos[1] = cola[i].getNumeroPedido();
            datos[2] = cola[i].ordenToString();
            datos[3] = cola[i].getTotal();
            dtm.addRow(datos);
        }
        return dtm;
    }
}
