# Echoes of the Lost Island

A Java-based interactive text adventure built with **JSP, Servlets, and JSTL**, where every decision leads to a different fate.  
You wake up stranded on a dark, mysterious island with your companion Sam — survival depends on your choices.

---

## Story Overview  

The story unfolds through a series of interconnected “states”:

- **Shore** – The awakening. You and Sam decide between resting or exploring too soon.  
- **Jungle** – A haunting scream tempts curiosity... or doom.  
- **Cave** – Ancient carvings, strange energy, and the path to the unknown.  
- **Ruins** – The island reveals its truth — the artifact, the altar, and fate’s final test.  
- **End Cave** – Multiple endings depending on your past choices: discovery, survival, or eternal silence.  

Each state lets the player make decisions that lead to new paths — or death.

---

## Tech Stack  

| Technology | Purpose |
|-------------|----------|
| **Java (Servlets)** | Handles game logic, requests, and state transitions |
| **JSP + JSTL** | Displays story text and player choices dynamically |
| **JUnit 5** | Automated testing for core game mechanics |
| **HTML + CSS** | Creates a dark, immersive visual experience |

---

## Project Structure  

| File / Folder | Description |
|----------------|-------------|
| `GameEngine.java` | Core logic: initializes states, handles choices, tracks endings |
| `GameServlet.java` | Connects the web pages (JSP) with the backend logic |
| `Player.java` | Holds player data (current state, alive status, artifact possession) |
| `State.java` | Represents story locations and their available choices |
| `Choice.java` | Links player decisions to other states |
| `Stats.java` | Tracks number of deaths and endings reached |
| `/webapp/*.jsp` | Front-end pages for each story scene |
| `/test/GameEngineTest.java` | Contains JUnit tests for validation |

---

## JUnit tests ensure that core game features work correctly, including:  
- Proper game initialization  
- Correct state transitions  
- Artifact logic  
- Restart and stats tracking  

## Endings & Stats: Each playthrough updates your statistics:
- Deaths
- Ending A: The True Escape
- Ending B: The Hollow Return
- Ending C: The Collapse
- Ending D: The Silence
- Games Played
These stats are displayed dynamically during the endings and death screens.

