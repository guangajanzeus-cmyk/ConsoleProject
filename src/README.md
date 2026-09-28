# Burger Cooking Game (Java Swing + OOP)

## Paano i-run
1. Ilagay lahat ng `.java` files sa isang folder (o sa `src/` package ng IDE mo — IntelliJ/Eclipse/VS Code).
2. Compile:
   ```
   javac *.java
   ```
3. Run:
   ```
   java Main
   ```

## Paano laruin
- May order sa taas (e.g. "Bun + Patty + Cheese + Fries") at 30-second timer.
- Click **Start Cooking** sa Grill/Fryer, bantayan status text — "PERFECT NOW!" ang signal mong click **Take Off**.
- Click **Add Bun** / **Add Cheese** para instant idagdag (walang cooking needed).
- Kapag kumpleto na ang tray ayon sa order, click **Submit Order**.
- Scoring: Perfect = 10pts, Over/Undercooked = 5pts, Burnt = 0pts, +20 bonus kung lahat Perfect.

## OOP concepts na ginamit
| Concept | Saan |
|---|---|
| Abstraction | `Ingredient` abstract class |
| Inheritance | `Patty`, `Fries`, `Bun`, `Cheese` extend `Ingredient` |
| Polymorphism | `CookingStation` works with any `Ingredient` subtype via `Supplier<Ingredient>` |
| Encapsulation | `Order` hides internal list, returns copies only |

## Files
- `Ingredient.java` — abstract base class
- `Patty.java`, `Fries.java`, `Bun.java`, `Cheese.java` — ingredient subclasses
- `Order.java` — random order generator + matching logic
- `TrayItem.java` — data holder for served items
- `CookingStation.java` — reusable Swing panel for cooking (Timer-based)
- `GamePanel.java` — main game screen (order, timer, tray, scoring)
- `MainFrame.java` — JFrame window
- `Main.java` — entry point (`public static void main`)

## Puwede mong i-extend
- Dagdag ingredients (Lettuce, Tomato, Bacon)
- Difficulty levels (mas mabilis burn time)
- Sound effects / images gamit ImageIcon
- Leaderboard / high score save sa file
