🛡️ Attack on Titan: Utopia
Attack on Titan: Utopia is a single-player, endless tower defense game inspired by the iconic anime Attack on Titan. Developed using Java and JavaFX, the game challenges players to defend humanity's last stronghold — the Utopia District — from waves of terrifying titans.

📖 Story
The titans have breached Wall Maria and are now threatening the northern border of Wall Rose at the Utopia District. You are humanity’s final hope. Deploy anti-titan weaponry strategically across defensive lanes and hold off the onslaught for as long as you can. Once all walls fall, it’s game over — but how long can you survive?

⚔️ Game Mechanics
🎮 Gameplay Overview
Genre: Endless Tower Defense

Objective: Protect all wall sections from being destroyed by titans

Lose Condition: All lanes become lost (walls destroyed)

Win Condition: None — survive as long as you can!

🗺️ Battle Setting
The battlefield consists of multiple lanes, each with:

A wall section to defend (with HP)

Titans marching toward the wall

Weapons deployed to stop them

Titans are added from a queue and distributed to the lanes based on their danger level

🧟 Enemy Types (Titans)
Titan Type	HP	Damage	Speed	Special Trait
Pure Titan	100	15	10	Basic unit
Abnormal Titan	100	20	15	Attacks twice per turn
Armored Titan	200	85	10	Takes only 25% of incoming damage
Colossal Titan	1000	100	5→∞	Gains +1 speed after each move
🛠️ Friendly Units (Weapons)
Weapon Name	Price	Damage	Special Mechanic
Piercing Cannon	25	10	Attacks 5 closest titans in the lane
Sniper Cannon	25	35	Attacks the first titan in the lane
Volley Spread Cannon	100	5	Hits all titans between min/max range
Wall Trap	75	100	Attacks first titan at the wall
🔄 Turn Structure
Each turn consists of:

Player Phase: Buy and deploy a weapon or pass

Titan Movement: Titans advance toward the wall

Weapon Attacks

Titan Attacks

Titan Spawn: New titans are added from the queue

Battle Phase Update: Game escalates over time

🔥 Battle Phases
Turns Elapsed	Phase	Titans Spawned/Turn	Titan Queue
0–14	Early	1	Pure, Pure, Pure, Abnormal, etc.
15–29	Intense	1	More Abnormals, Armored, Colossal
30–34	Grumbling	1	Mostly Colossal Titans
35+	Grumbling	2 → doubles every 5	Infinite Colossal carnage
🧪 Features
Real-time GUI using JavaFX

Strategic lane-based defense logic

Multiple enemy behaviors and difficulty scaling

Score and resource tracking

🧠 Concepts Practiced
OOP (Encapsulation, Inheritance, Polymorphism)

JavaFX GUI Development

Turn-based game logic

Data modeling of dynamic units (Titans & Weapons)

Strategy and real-time decision-making mechanics


🧩 Future Ideas
Save and load functionality

Sound effects and animations

Titan boss waves and unique events
