public class Main {
    public static void main(String[] args) {
        CuentaCorporativa cuenta = new CuentaCorporativa("CTA-CORP-77", "BAJO");

        ObservadorNormativo lavado = new SubsistPrevencionLavado();
        ObservadorNormativo legal = new SubsistAnalisisLegal();
        ObservadorNormativo regulador = new SubsistOrganismoRegulador();

        cuenta.suscribir(lavado);
        cuenta.suscribir(legal);
        cuenta.suscribir(regulador);

        ReporteAuditoriaNormativa reporte1 = cuenta.actualizarRiesgo("MEDIO");
        System.out.println(reporte1.obtenerResumen());

        ReporteAuditoriaNormativa reporte2 = cuenta.actualizarRiesgo("ALTO");
        System.out.println(reporte2.obtenerResumen());
    }
}