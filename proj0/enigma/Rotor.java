package enigma;

import static enigma.EnigmaException.*;

/** Superclass that represents a rotor in the enigma machine.
 *  @author Nam Anh Mai
 */
public class Rotor {

    /** A rotor named NAME whose permutation is given by PERM. */
    public Rotor(String name, Permutation perm) {
        _name = name;
        _permutation = perm;
        // FIXME - Assign any additional instance variables.
        _setting = 0;
    }

    /** Return my name. */
    public String name() {
        return _name;
    }

    /** Return my alphabet. */
    public Alphabet alphabet() {
        return _permutation.alphabet();
    }

    /** Return my permutation. */
    public Permutation permutation() {
        return _permutation;
    }

    /** Return the size of my alphabet. */
    public int size() {
        return _permutation.size();
    }

    /** Return true if and only if I have a ratchet and can move. */
    public boolean rotates() {
        return false;
    }

    /** Return true if and only if I reflect. */
    public boolean reflecting() {
        return false;
    }

    /** Return my current setting. */
    public int setting() {
        // FIXME - How do we keep track of my current position?
        return _setting;
    }

    /** Set setting() to POSN.  */
    public void set(int posn) {
        // FIXME - How do we update our current position, based on an alphabet index
        _setting = posn;
    }

    /** Set setting() to character CPOSN. */
    public void set(char cposn) {
        // FIXME - How do we update our current position, based on an alphabet character?
        _setting = _permutation.alphabet().toInt(cposn);
    }

    /** Return the conversion of P (an integer in the range 0..size()-1)
     *  according to my permutation. */
    public int convertForward(int p) {
        // FIXME - How do we permute the index P, taking into account my current position?
        int enterContact = _permutation.wrap(p + _setting);
        int permuteContact = _permutation.permute(enterContact);
        return _permutation.wrap(permuteContact - _setting);
    }

    /** Return the conversion of C (an integer in the range 0..size()-1)
     *  according to the inverse of my permutation. */
    public int convertBackward(int c) {
        // FIXME - How do we invert the index E, taking into account my current position?
        int enterContact = _permutation.wrap(c + _setting);
        int invertContact = _permutation.invert(enterContact);
        return _permutation.wrap(invertContact - _setting);
    }

    /** Returns true if and only if I am positioned to allow the rotor
     * to my left to advance. */
    public boolean atNotch() {
        return false;
    }

    /** Advance me one position, if possible. By default, does nothing. */
    public void advance() {
    }

    @Override
    public String toString() {
        return "Rotor " + _name;
    }

    /** My name. */
    private final String _name;

    /** The permutation implemented by this rotor in its 0 position. */
    private Permutation _permutation;

    // FIXME - How do we keep track of what position I am in?
    private int _setting;

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED

}
