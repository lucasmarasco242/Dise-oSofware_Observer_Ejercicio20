Ejercicio 20 - Sistema Empresarial de Cumplimiento Normativo y Auditoría de Riesgos

Explicación del programa

En este ejercicio se implementó el patrón de diseño Observer para notificar cambios en el nivel de riesgo de una cuenta corporativa a subsistemas normativos, aislando errores por observador y generando un reporte inmutable de auditoría, sin utilizar librerías externas ni imports.
El programa cuenta con:
- Una interfaz ObservadorNormativo con los métodos obtenerEntidad() y alCambiarRiesgo(String cuentaId, String riesgoAnterior, String riesgoNuevo).
- Una clase inmutable ReporteAuditoriaNormativa que almacena las entidades notificadas con éxito y las incidencias registradas.
- Tres clases observadoras (SubsistPrevencionLavado, SubsistAnalisisLegal y SubsistOrganismoRegulador) que procesan el cambio de riesgo.
- Una clase CuentaCorporativa que sincroniza la gestión de observadores, aísla excepciones por observador y devuelve el reporte de auditoría.

Luego, dentro del método main, se crea una cuenta corporativa, se suscriben los subsistemas y se actualizan los niveles de riesgo mostrando el resumen de auditoría.

Lógica utilizada

La lógica del programa consiste en:
- Sincronizar las operaciones sobre la lista de observadores y trabajar sobre una copia durante la notificación.
- Capturar excepciones en cada observador por separado para evitar fallos en cascada.
- Construir un ReporteAuditoriaNormativa inmutable con el resultado de cada entidad.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
[PREVENCION LAVADO] Revisando movimientos de cuenta CTA-CORP-77 (BAJO -> MEDIO)
[ANALISIS LEGAL] Verificando cláusulas de cuenta CTA-CORP-77 con riesgo MEDIO
[ORGANISMO REGULADOR] Notificando cambio de cuenta CTA-CORP-77 a MEDIO
Auditoria [CTA-CORP-77: BAJO -> MEDIO] Exitosos: PrevencionLavado, AnalisisLegal, OrganismoRegulador | Incidencias: ninguna
[PREVENCION LAVADO] Revisando movimientos de cuenta CTA-CORP-77 (MEDIO -> ALTO)
[ORGANISMO REGULADOR] Notificando cambio de cuenta CTA-CORP-77 a ALTO
Auditoria [CTA-CORP-77: MEDIO -> ALTO] Exitosos: PrevencionLavado, OrganismoRegulador | Incidencias: AnalisisLegal: Revisión contractual pendiente en AnalisisLegal para CTA-CORP-77

Captura de pantalla

<img width="1575" height="287" alt="image" src="https://github.com/user-attachments/assets/c49b5e51-f41f-4e5e-a4d5-3b76df0e5d23" />
