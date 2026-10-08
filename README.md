# Testing y Clean Code con Java – Parte 2

Segunda parte del *Curso Completo de Testing y Clean Code con Java* (ATL Academy – Lucas Moy):
**Mockito** y **Clean Code / Refactorización** sobre el juego *Piedra, Papel o Tijera*.

## Tecnologías
- Java 17+
- JUnit **4.13.2**
- Mockito 5
- Maven
- Lubuntu (VirtualBox)

## Proceso (ver historial de commits)
1. **Etapa 1:** código original (legacy) y 6 pruebas con Mockito (`@Mock Scanner`, `@Mock Random`, `@InjectMocks`).
2. **Etapa 2:** refactorización con Clean Code; las 6 pruebas siguen pasando.
3. **Etapa 3:** pruebas adicionales → **21 pruebas**.

## Principios de Clean Code aplicados
| Antes | Después | Principio |
|---|---|---|
| Números mágicos `1, 2, 3` | `enum GameOption` | Sin números mágicos |
| Contadores sueltos | Clase `ScoreBoard` | Responsabilidad única |
| Método `play()` de ~90 líneas | Métodos pequeños | Funciones cortas |
| Comentarios en cada línea | Nombres descriptivos | Código autoexplicativo |
| Texto duplicado | Constante `INSTRUCTIONS` | DRY |
| `if/else` para decidir ganador | `GameOption.beats()` | Lógica en el objeto correcto |
| `System.exit(0)` | Salida limpia del bucle | Código testeable |
| `new Scanner()` interno | Constructor `Game(Scanner, Random)` | Inyección de dependencias |

## Error encontrado en la solución del curso
En la solución oficial, `completeGamePlay()` no tiene `else` antes de `lose(...)`, por lo que
el jugador suma una derrota aun cuando gana o empata. Las pruebas del curso no lo detectaban;
aquí se agregó la verificación `loses:0` y se corrigió en la refactorización.

## Ejecutar pruebas
    mvn test

Resultado: `Tests run: 21, Failures: 0, Errors: 0` – **BUILD SUCCESS**

![Etapa 1](docs/etapa1-tests.png)
![Etapa 2](docs/etapa2-refactor.png)
![Etapa 3](docs/etapa3-tests.png)

## Jugar
    mvn -q compile
    java -cp target/classes com.jeffersonib.rps.Main

**Autor:** Jefferson Ibañez (JeffersonIB)
