package game.character.charactercreate;

import game.character.Character;
import game.character.player.CharacterClass;
import game.character.player.CharacterType;
import game.character.player.Player;

/**
 * PlayerCreator class that extends the CharacterCreator abstract class. Responsible for creating the playable
 * character by combining the character Type and character Class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class PlayerCreator extends CharacterCreator {
    private final CharacterType type;
    private final CharacterClass cls;

    /**
     * Constructor for creating the playable character given a character type and character class
     *
     * @param type character type to be generated
     * @param cls  character class to be generated
     */
    public PlayerCreator(CharacterType type, CharacterClass cls) {
        this.type = type;
        this.cls = cls;
    }

    /**
     * @see CharacterCreator#createCharacter()
     */
    @Override
    public Character createCharacter() {
        return new Player(type, cls);
    }
}