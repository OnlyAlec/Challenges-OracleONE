# Conversor de Monedas!

Bienvenido, en este challenge del curso de Oracle ONE se realizo un programa en **Java** el cual es un conversor de monedas usando la API de *Exchangerate*.

## Caracteristicas:
- Puede convertir las siguientes monedas: **MXN, USD, YEN, EUR**.
- Te muestra el resultado directo de conversión, así como la tasa de conversión.
- Guarda una lista de transacciones de conversiones que a hecho el usuario.
## Funcionamiento:
El programa no es complejo ya que se busco hacer lo más simple posible, evitando el calculo de la conversión debido a que la API nos permite dar directamente los cambios que queremos hacer entre monedas, siendo que solo se obtiene el dato y lo presenta al usuario.

Para los registros, se van guardando en una lista usando la información que regresa la API, implementando un formato de fecha para mejor experiencia del usuario.
## Clases implementadas:
- `Conversor`: *Clase* encargada de realizar la petición a la API y de mostrar las transacciones.
- `Conversion`: *Record* encargada de transformar la información recibida a una clase `Conversor`, así como darle formato para la impresión en consola.
## Demo:
### Menús:
![imagen](https://github.com/OnlyAlec/Challenges-OracleONE/assets/66844946/d13a0ffa-9b95-4c34-a02f-f109fb9aa864)
![imagen](https://github.com/OnlyAlec/Challenges-OracleONE/assets/66844946/68402a42-57a7-4966-b495-9c5033fcf755)
### Conversion:
![imagen](https://github.com/OnlyAlec/Challenges-OracleONE/assets/66844946/cc1741bc-c2cf-45a1-8022-3d00cb46ba6a)
### Transacciones:
![imagen](https://github.com/OnlyAlec/Challenges-OracleONE/assets/66844946/778c52e6-4805-4a68-a12a-6fb9e654772e)

