# SER316 - Borys Banaszkiewicz

## Description 

The design pattern that I plan to implement for this project will likely be the Strategy Behavioral Design Pattern because
this design pattern involves encapsulating algorithms into separate classes so that they are interchangeable.
Specifically, since this is an RPG game and different characters have different attack and defense powers and levels, it 
will enable me to define the main functionality/behaviors that characters have, such as attack and defense mechanisms, and 
allow me to apply different traits to different characters without changing or effecting the main programs' logic.


## Requirements
### General
Introduction and end goal. This game is meant to simulate an RPG centric ’dungeon
crawler’ type game, where you get to (lightly) customize your character, fight enemies,
level up, get stronger, lose, and do it all over again! Enemies should get harder each
subsequent floor. The combat in the game should be turn based.   
The end goal of the game should be a ’Final Boss’ or sorts that is meant to test the culmination of your
strength to that point. If you defeat the Final Boss, you win. If you lose against the Final
Boss, you do not go back to the first floor, you lose and the game is over! Number and
Power balancing should be up to you, just be sure that it is something interesting enough
to facilitate moving through a dungeon as an adventurer! 


The most important thing is to
have fun with it, so please take the time to make this your own, and add as much flare to
it as you would like.


## Requirements
Below are some of the functional requirements for the application.
RPG-simulator
 - [ ] You must be able to choose a class for your character (or have it assigned randomly),
each class has a different subset of skills or magic. A class would constitute something
along the lines of ’fighter’, ’mage’, ’thief’, get creative with it!  


- [ ] You should be able to choose a type for your character (or have it assigned randomly),
each race should have one passive skill that gets better after leveling up or that gives
them advantage over another. rate A type would constitute something like, ’orc’,
’elf’, ’dwarf’, ’human’. Perhaps orcs are stronger naturally, perhaps elves are the
most nimble and can dodge better, maybe humans have less HP but gain exp at a
faster, get creative with it!  


- [ ] You should encounter a randomly generated ’small’ enemy every floor, a ’medium’
enemy every 5 floors, and a ’BOSS’ every 10 floors.  


- [ ] Your character should be able to equip items such as a sword, shield, helmet, armor,
boots, etc. Your character should be able to equip a minimum of 3 unique item
types. You get to decide what happens if you come across a second item type. For
example, if you have 3 different swords you have programmed, and you have one
equipped and come across another, does it automatically replace the old one? Does
it compare stats and pick the better one? What happens if you don’t take it? If
you only have one sword programmed and you already have one equipped and come
across a new one, what happens?  


- [ ] After each battle you should have a small chance to find a chest that contains items
such as armor/money/potions, or a shop where you can spend your money.  


- [ ] The shop should sell 3 random objects, weapons, magic scrolls (good for one use),
potions (good for one use), instant level up (RARE), get creative with it.  


- [ ] Potions should never give more Health or Mana than you have as a maximum.  


- [ ] After each floor (and after each possible random encounter with a shop) you should
go back to the top floor if your health is below 15%. Going to the top floor gives
you back all of your health and mana  


- [ ] All enemies should get harder for each floor you travel to, for example, an enemy on
floor 2 should be much, much weaker than an enemy on floor 48!  


- [ ] The game should run on cycles. A cycle is considered to be 4 parts. Q1, Q2, Q3,
and Q4.  


- [ ] Each part should last around 3-5 floors have it’s own event (use your creativity,
here’s a few examples to get started)
    - [ ] Q1 - Physical attacks always deal X amount less damage
    - [ ] Q2 - 5% chance to take a second turn in a row (applies to enemies as well
    - [ ] Q3 - gain extra money!


- [ ] Your character should have at minimum:
    - [ ] Stats: Attack, Health, Mana/Other Resource such as cooldown, Defense, and
  speed. Others can be added.
    - [ ] Should have at least 1 skill or magic power they can use
    - [ ] Physical attacks should have a chance to critically strike (double damage)
    - [ ] All attacks should have a chance to fail/miss
    - [ ] Attacks should deal a min damage of 1


- [ ] You gain experience from winning battles, at certain thresholds you should be able
  to choose a skill or magic power to upgrade. For example:
    - [ ] Lvl 1: Strike
    - [ ] Lvl 10: Double Strike


- [ ] Lvl 15: Triple Strike NOTE: Leveling up should only happen when at the top floor.
  For example, if I have 300 experience and go back to the top floor and I’m level 1
  (previous experience cap = 0), if we assume the experience to level up is 10 * 2 *
  current level + previous experience cap.
  Example:

    - [ ] Level 1, it would be 10 * 2 * 1 + 0 (since there was no previous level = 20 (300
  total exp - 20, so now 280)
    - [ ] Level 2 would be 10 * 2 * 2 + 20 = 60 (220 remain) Overall, you should level up
3 times with 100 exp left over towards the next level. (JUST AN EXAMPLE,
YOU CAN USE YOUR OWN FORMULAS)


- [ ] During combat:
    - [ ] Attacks and item usage should happen in a turn based fashion, the participant
with the highest speed should go first.
   - [ ] When a participant reaches 0 or less HP, they lose the fight, if the loser is you,
you lose an amount of money and go back to the top floor and only gain 20
   - [ ] During either participants turn, they can either attack or use a consumable
item.
 - [ ] Your simulation should include at least 3 temporary status effect and at least 1 permanent
status effect that either hinders or helps your character in some way. Status
effects could include: poisoned, burned, asleep, paralyzed, strengthened, quickened,
crippled, bleeding, cursed, etc.  


It is all purposefully pretty wide open to give you more options and have you think about
things more. You can be creative on this; if you like a different idea better, go for it. It
is more about having a rough framework in which you want to work and doing something
fun with implementing Design Patterns than the particular requirements.
Some HINTS (not requirements):
 - [ ] You could use decorator pattern for evolutions.
 - [ ] To build new code-a-mon or trainers you could use the factory pattern.
 - [ ] The simulation should be tick-based. (Mediator pattern). Each tick something
should happen, the trainer battles, catches new code-a-mon, purchases items, etc.



# Design Patterns

## Factory Design Pattern
- [ ] You must be able to choose a class for your character (or have it assigned randomly),
  each class has a different subset of skills or magic. A class would constitute something
  along the lines of ’fighter’, ’mage’, ’thief’, get creative with it!


- [ ] You should be able to choose a type for your character (or have it assigned randomly),
  each race should have one passive skill that gets better after leveling up or that gives
  them advantage over another. rate A type would constitute something like, ’orc’,
  ’elf’, ’dwarf’, ’human’. Perhaps orcs are stronger naturally, perhaps elves are the
  most nimble and can dodge better, maybe humans have less HP but gain exp at a
  faster, get creative with it!


- [ ] Your character should be able to equip items such as a sword, shield, helmet, armor,
  boots, etc. Your character should be able to equip a minimum of 3 unique item
  types. You get to decide what happens if you come across a second item type. For
  example, if you have 3 different swords you have programmed, and you have one
  equipped and come across another, does it automatically replace the old one? Does
  it compare stats and pick the better one? What happens if you don’t take it? If
  you only have one sword programmed and you already have one equipped and come
  across a new one, what happens?

- [ ] Your character should have at minimum:
    - [ ] Stats: Attack, Health, Mana/Other Resource such as cooldown, Defense, and
      speed. Others can be added.
    - [ ] Should have at least 1 skill or magic power they can use
    - [ ] Physical attacks should have a chance to critically strike (double damage)
    - [ ] All attacks should have a chance to fail/miss
    - [ ] Attacks should deal a min damage of 1

## Decorator Design Pattern
- [ ] Potions should never give more Health or Mana than you have as a maximum.


- [ ] You gain experience from winning battles, at certain thresholds you should be able
  to choose a skill or magic power to upgrade. For example:
    - [ ] Lvl 1: Strike
    - [ ] Lvl 10: Double Strike


- [ ] Lvl 15: Triple Strike NOTE: Leveling up should only happen when at the top floor.
  For example, if I have 300 experience and go back to the top floor and I’m level 1
  (previous experience cap = 0), if we assume the experience to level up is 10 * 2 *
  current level + previous experience cap.
  Example:

    - [ ] Level 1, it would be 10 * 2 * 1 + 0 (since there was no previous level = 20 (300
      total exp - 20, so now 280)
    - [ ] Level 2 would be 10 * 2 * 2 + 20 = 60 (220 remain) Overall, you should level up
      3 times with 100 exp left over towards the next level. (JUST AN EXAMPLE,
      YOU CAN USE YOUR OWN FORMULAS)


## Strategy Design Pattern
- [ ] During combat:
    - [ ] Attacks and item usage should happen in a turn based fashion, the participant
      with the highest speed should go first.
    - [ ] When a participant reaches 0 or less HP, they lose the fight, if the loser is you,
      you lose an amount of money and go back to the top floor and only gain 20
    - [ ] During either participants turn, they can either attack or use a consumable
      item.
- [ ] Your simulation should include at least 3 temporary status effect and at least 1 permanent
  status effect that either hinders or helps your character in some way. Status
  effects could include: poisoned, burned, asleep, paralyzed, strengthened, quickened,
  crippled, bleeding, cursed, etc.


## Mediator Design Pattern
- [ ] You should encounter a randomly generated ’small’ enemy every floor, a ’medium’
  enemy every 5 floors, and a ’BOSS’ every 10 floors.

- [ ] After each battle you should have a small chance to find a chest that contains items
  such as armor/money/potions, or a shop where you can spend your money.


- [ ] The shop should sell 3 random objects, weapons, magic scrolls (good for one use),
  potions (good for one use), instant level up (RARE), get creative with it.


- [ ] After each floor (and after each possible random encounter with a shop) you should
  go back to the top floor if your health is below 15%. Going to the top floor gives
  you back all of your health and mana


- [ ] All enemies should get harder for each floor you travel to, for example, an enemy on
  floor 2 should be much, much weaker than an enemy on floor 48!


- [ ] The game should run on cycles. A cycle is considered to be 4 parts. Q1, Q2, Q3,
  and Q4.


- [ ] Each part should last around 3-5 floors have it’s own event (use your creativity,
  here’s a few examples to get started)
    - [ ] Q1 - Physical attacks always deal X amount less damage
    - [ ] Q2 - 5% chance to take a second turn in a row (applies to enemies as well
    - [ ] Q3 - gain extra money!