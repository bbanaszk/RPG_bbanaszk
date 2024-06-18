# Borys Banaszkiewicz - Assignment 5
![Party Wizard](partywizard.gif)

## NOTE
It is all purposefully pretty wide open to give you more options and have you think about
things more. You can be creative on this; if you like a different idea better, go for it. It
is more about having a rough framework in which you want to work and doing something
fun with implementing Design Patterns than the particular requirements.

## Description (UPDATE)

Introduction and end goal. This game is meant to simulate an RPG centric ’dungeon
crawler’ type game, where you get to (lightly) customize your character, fight enemies,
level up, get stronger, lose, and do it all over again! Enemies should get harder each
subsequent floor. The combat in the game should be turn based. The end goal of the
game should be a ’Final Boss’ or sorts that is meant to test the culmination of your
strength to that point. If you defeat the Final Boss, you win. If you lose against the Final
Boss, you do not go back to the first floor, you lose and the game is over! Number and
Power balancing should be up to you, just be sure that it is something interesting enough
to facilitate moving through a dungeon as an adventurer! The most important thing is to
have fun with it, so please take the time to make this your own, and add as much flare to
it as you would like.

* Please run `gradle runServer -Pport=port` and `gradle runClient -Pport=port -Phost=hostIP` together.
* Can also be ran using `gradle runServer` and `gradle runClient` for localhost and default port
* Programs runs on hostIP
* Port and hostIP specification is optional.

## Requirements

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
  it compare stats and pick the better one? What happens if you don’t take it? If you only have one sword programmed and you already have one equipped and come
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

Some HINTS (not requirements):
- [ ] You could use decorator pattern for evolutions.
- [ ] To build new code-a-mon or trainers you could use the factory pattern.
- [ ] The simulation should be tick-based. (Mediator pattern). Each tick something
  should happen, the trainer battles, catches new code-a-mon, purchases items, etc.


# Submission 5a (SEE SPECIFICS BELOW)
For submission A, I want you to have your basic setup done. Private repo, simple Main
(can just be a hello world) that can be run through Gradle, GitHub Actions included (and
passing), Checkstyle, Spotbugs, basic test setup with a simple test. So basically everything
but the real implementation should be done.

I also want to have a short summary in the Readme.md on GitHub which explains your
rough idea for the Design Patterns you plan to implement (you can still change your mind
later). This can be very basic since we have not covered a lot about Design Patterns yet.
Submit your link to the private repo on Canvas (ser316asu added as collaborator). No
PDF is needed at this point and no screencast.
This submission has 15 of the overall points
- [ ] Clean Git repo - 3pts
- [ ] Gradle works correctly - 3pts
- [ ] Checkstyle and Spotbugs included - 3pts
- [ ] GitHub Action setup and passes - 2pts
- [ ] JUNIT included and test runs and passes - 2pts Readme has basic idea explained - 2pts

# Submission 5b (SEE SPECIFICS BELOW)
You need to submit your code with your Design Patterns and all that is asked above
- [ ] A link to your GitHub repository (also include in the PDF)
- [ ] A link to your screencast (also include in the PDF)
- [ ] A PDF document explaining everything that is asked above in the general assignment.
  Submit the PDF directly on Canvas

# Specifics
IMPORTANT: If your Code has compile errors you will receive 0 points, we will not debug
anything. Make sure your Main runs without errors. Example you are only able to make
2 of the 3 Design Pattern run in your Main and the 3rd is implemented but does not work.
Then you should not include number 3 in your Main. You will get credit for the the two
DP and will get partial credit for number 3 (if it has no compile errors).
As stated before, you do not have to implement all the requirements and you can choose
any 3 design patterns from the Gang of Four for task 1 that you see fit. You are relatively
free on how to do things. Please mark where you see your Design Patterns in your code.
Again, this is coding intensive. Start early, as it will take a while to figure things out.

- [ ] Work on Git and GitHub for this assignment (on a private repo, add ser316asu
  as collaborator). This includes good commit messages and a clean repo, etc. (7
  points). Name it what you want as long as it is not rude/weird, same goes for
  commit messages.


- [ ] The implementation needs to be in Java


- [ ] Each Design Pattern is worth 15 points (45 points) :
    - [ ] You need to create 3 design patterns from the Gang of Four for the requirements
      mentioned in the separate document.
    - [ ] You do need to implement different Design Patterns, preferably from different
      categories.
    - [ ] You have two choices:
        - The minimal requirement for up to 95% of credit: Have the Design Patterns
          implemented independently from each other (the patterns should not "work
          together"). Basically, each one of them can be run separately. In this case,
          you would implement each pattern in a separate package. In a Main class,
          first show the functionality of one pattern and then the other etc. This is
          the easier version, since the DP are not intertwined which many struggle
          with.
        - Getting full points plus some extra credit: Implement your code with the
          Design Patterns being intertwined (you can of course still have packages
          if you like), working together and forming one good project. The DP still
          need to be implemented correctly and make sense!
    - [ ] Make sure you comment your code well so we can see what you are doing or
      tried to do.
    - [ ] You do NOT need to meet all the functional requirements specified in the
      other document, but each Design Pattern should at least implement 3 of the
      requirements (not all might fit into your Design Pattern but might just be other
      side functionalities in your code). In your PDF, describe which requirements
      you fulfilled and also make sure you comment on it in your code. If you chose
      version 2 above, then 9 requirements need to be fulfilled overall in your code.
    - [ ] The code needs to be fully functional and needs to "do something"! There needs
      to be a basic simulation that shows the functionality of the requirements you
      chose. Just creating the skeleton of the Design Pattern with no data is NOT
      sufficient. I want to see a running functional implementation.
    - [ ] In your Readme you need to include a section in which you mention your sources
      for the Design Patterns, explain why the Design Pattern is a good choice where
      you implemented it and explain exactly how you utilize it! This needs to be
      detailed.
    - [ ] Make sure your Main does have good print outs so we and you can see what is
      going on.
    - [ ] We will grade you based on the code that you’ve written. This is based on all
      you have learned so far: Good coding practice, testing, coding standards, clean
      repo, etc.
    - [ ] Minimal Requirement for each package: There is some kind of simulation
      included in Main that includes some data being created and some kind of simulation
      doing something that makes sense. Just creating the rough outline of
      the code structure is not enough.
    - [ ] Things in Main need to run fully automated, we will not have time
      during grading to actually "play"


- [ ] Create a Gradle file (5 points) - requirements (All the below Gradle requirements
  are mandatory, you will not get points for this assignment if this
  does not work). We will NOT import anything into an IDE!
    - [ ] Your code HAS TO execute via "gradle run" via command line
    - [ ] Include Checkstyle and Spotbugs
    - [ ] Include JUnit 4 or 5


- [ ] Checkstyle and Spotbugs: make sure you adhere to the coding standards you set in
  your Checkstyle XML and that Checkstyle and SpotBugs do not show anything. If
  you cannot get rid of everything, you should mention this in your PDF document
  and explain why you were not able to fix it.
    - In your PDF (or README): include a screenshot of your Spotbugs and Checkstyle
      report. You will not get points for this if there are no screenshots that show
      us your reports. (10 points)


- [ ] GitHub Actions: Set up GitHub Actions CI so it builds your project, runs your Unit
  Tests and also Spotbugs and Checkstyle. (5 points)


- [ ] Include JUnit tests and test your code. You should reach at least 70% code coverage
  (excluding your Main, getters and setters).
  In your PDF (or README): include a screenshot of your JUnit and Jacoco
  report, showing your tests pass and your code coverage. You will not get points for
  this if there are no screenshots that show us your reports.(15 points)


- [ ] Include a short screencast showing you doing a git clone from your repo, gradle
  build, showing your reports (JUnit, Spotbugs, Checkstyle, GitHub Actions CI), and
  gradle run. Show your system in action (max. 6min). (8 points)


- [ ] In your README on GitHub (well written)
  • Include a link to your screencast
  • Explain each of your Design Patterns briefly and mention which of the requirements
  you fulfilled with this Pattern. (5 points)

# Assignment 5a rubric
- [ ] private repo exists, with good gitignore and no temporary files (3 points)
    - Repo is clean, no unnecessary files.
    - Everything that is needed to build exists.


- [ ] build.gradle Hle exists and builds and runs project (2 points)
    - Build must pass and the Main must run correctly


- [ ] with gradle build checkstyle and spotbugs report is generated (3 points)


- [ ] GitHub action is setup (3 points)
    - GitHub Action CI is setup and build is successful.


- [ ] Unit Tests run with gradle build (2 points)


- [ ] Readme mentions the rough idea what DP to implement (2 points)


- [ ] ser316asu is invited  (0 points -- deductions if not completed)
    - If the grading team has not access to the repo when we grade you
      will loose all points. If you add us later after we ask, we will add
      points again but deduct 3 points for not adding us right away.

# Assignment 5b rubric
- [ ] Git workflow (4 points)
    - good commit messages
    - clean repository


- [ ] Design Pattern 1 (10 points)
    - Design Pattern are implemented (either working separatly or together)
    - Design Pattern makes sense and is implemented correctly
    - Code is well written
    - Code fulfills at least 3 requirements per pattern or if put together 9 requiremens
    - Main methods runs both patterns, it runs a good simulation with good prints and the code does something that makes sense
    - Code if fully functional and is not just a skeleton of the DP but it actually has good functionality


- [ ] Design Pattern 2 (10 points)
    - Design Pattern are implemented (either working separatly or together)
    - Design Pattern makes sense and is implemented correctly
    - Code is well written
    - Code fulfills at least 3 requirements per pattern or if put together 9 requiremens
    - Main methods runs both patterns, it runs a good simulation with good prints and the code does something that makes sense
    - Code if fully functional and is not just a skeleton of the DP but it actually has good functionality


- [ ] Design Pattern 3 (10 points)
    - Design Pattern are implemented (either working separatly or together)
    - Design Pattern makes sense and is implemented correctly
    - Code is well written
    - Code fulfills at least 3 requirements per pattern or if put together 9 requiremens
    - Main methods runs both patterns, it runs a good simulation with good prints and the code does something that makes sense
    - Code if fully functional and is not just a skeleton of the DP but it actually has good functionality


- [ ] Spotbugs/Checkstyle (7 points)
    - after running gradle build the reports are clean
    - no Spotbugs violation (unless they mention that they could not get rid of it due to a specific reason in the PDF)
    - few checkstyle violations (not more than 5 unless a good reason)


- [ ] The build passes on GitHub Actions (3 points)


- [ ] Unit Tests (13 points)
    - good tests are created
    - tests are well written
    - good comments
    - all tests pass
    - at least 80% coverage reached (main does not have to be included)


- [ ] Readme and PDF (3 points)
    - Include a screenshot of your Gradle run and Gradle build.
    - Include a screenshot of your GitHub Actions.
    - Include a screenshot of your Spotbugs and Checkstyle report.
      Include a screenshot of your Unit Test report.
    - Include the link to your screencast.
    - Include your GitHub link


- [ ] Late Submission (-8.5 points if submitted late)


- [ ] DP do not work together (-5 points)
    - This is basically taken off from the DP parts


- [ ] Gradle works correctly (req 3) (2 points)


- [ ] Screencast (8 points)


- [ ] Acquire and apply new knowledge as needed, using appropriate learning strategies. (15 points)
    - In your Readme you need to include a section in which you mention your sources
      for the Design Patterns, explain why the Design Pattern is a good choice where you implemented it and explain exactly how you utilize it! This needs to be detailed. 5 points for each DP


