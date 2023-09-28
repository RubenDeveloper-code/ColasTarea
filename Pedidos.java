package unidat3.colas;

public class Pedidos {
    private String nombreCliente;
    private int numeroPedido;
    private int orden[] = new int[6];
    private float total;
    final static int precios[]= {25,30,30,40,70,25};
    final static String[] menu = {"Tacos","Sopes","Pambasos","Tostadas","Flautas","Quesadillas"};

    public Pedidos(String nombreCliente, int numeroPedido) {
        this.nombreCliente = nombreCliente;
        this.numeroPedido = numeroPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public int[] getOrden() {
        return orden;
    }

    public float getTotal() {
        return total;
    }

    public void calcularTotal() {
        int tempTT=0;
        for(int i = 0; i < 6; i++)
            tempTT+=precios[i]*orden[i];
        total = tempTT;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setOrden(int[] orden) {
        this.orden = orden;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String ordenToString() {
        String res = "";
        int i = 0;
        for(int element : orden) {
            if(element==0)continue;
            res+= menu[i++]+":" + element + "\n";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "nombreCliente=" + nombreCliente + ", numeroPedido=" + numeroPedido;
    }

}
