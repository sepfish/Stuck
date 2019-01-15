
public class DevelopNotes {

/*Hey, where am I now??
 *11/9: You just implemented "checking" an InteractObject. You were trying to make it turn red when it was checked.
 *11/16: You have problems with the isChecked setting back to false when it turns true - (try making the INteractObject its own little variable inside of GamePanel, not in the ObjectManager)
 *11/23: THANK GOD THAT PROBLEM IS SOLVED HHHHHH
 *		 anyway, you're debating whether to stick all the InteractObjects in an ArrayList
 *		 you should also start thinking about puzzles (finding key fragments (hehe Jevil), batteries for things, notes & passwords, etc)
 *		 you also created an inventory class... but pretty much didn't do anything in it
 *11/30: You did it. You implemented the ArrayList. You also created your first Inventory mock-up (it looks so bad hahaha)
 *		 You should start thinking about puzzles!!!! You also need to create more InteractObjects, and maybe get started on the art. 100px by 100px drawings seem pretty good for the inventory.
 *		 Maybe you should pixellate those Love Nikki home avatars haha
 *12/7:  JOKER FOR SSBU
 *		 anyway the inventory is pretty gucci right now, you fixed the "going down" problem
 *		 You need to implement a way to unlock things... (seeing as you have a key and you found out how to lock things now)
 *		 also put some art in bro!!!
 *		 and find some way to unlock the door
 *12/14: it's taku's birthday
 *		 You started doing (basic) graphics... do more :)
 *		 still need to find out how to unlock things
 *		 also puzzles
 *12/21: winter break bois
 *		 You did some more graphics... do more graphics
 *		 There's a problem with the chest and the mirror on the first floor swapping graphics, for whatever reason.
 *		 Also work on things mentioned above. Also fix the door graphics.
 *12/28: it's orlando's birthday? ok sure happy birthday orlando
 *		 Fixed the going down problem. Again.
 *		 Switched some colors around, introduced character moving states (for future graphics)
 *		 There's a problem with setting the images for the InteractObjects - they'll only draw the last image that was set, even though each InteractObject should have their own variable?
 *1/4:	 happy new year
 *		 Put in more graphics, spent half of class drawing a bookshelf and a lamp.
 *		 Plz think of puzzles :(
 *		 Think about how you're going to populate the second floor
 *		 Ladders/stairs still need figuring out (how graphics?)
 *		 Need to implement "walk cycle"/"run cycle" (not just flashing a different color)
 *		  - I don't think constructing a for loop will work. There needs to be some way that the character can cycle through at least 4 sprites. Either I have to make a gif, or I need to find some other way to do the thing
 *		 There's also a problem with the InteractObject's hasKey boolean setting back to false :(
 *		 Should also implement a way to have different flavor text for checking items, rather than just the "There's nothing inside." Like Undertale.
 *1/11:	 vespy definitive edition & laguz in heroes!!! having insane luck in heroes after the gigantic gap lol
 *		 Added a cycle of three different flavor text for checking items with certain conditions.
 *		 Started implementing things for the puzzles. Fixed the problem where you could check things on the first floor... on the second floor
 *		 Please fix the rgb values for the floor it's driving me nuts
 *		 As usual, keep implementing the puzzle stuff also the problem with the locking is Still There(tm)
 *1/14	 it's not friday! it's monday! also I only summoned two reysons :( rip +2 reyson
 *		 For the walk cycle, I would try first recording exactly when the GamePanel updates.
 *		 You should also have a method to update the character's sprite (using the g parameter) separate from update I guess, because update doesn't accept g
 *		 After so-and-so amount of updates, character sprite changes. I'm thinking three
 *		 Also I think the problem with the key booleans and unlocking is that 1. it's a member variable and 2. it's not a keyEvent so it would be hard to fix like the checking boolean
 *		 I would try not making it a member variable and instead setting it somewhere... ugh another setter but I think it's the only way
 *		 Also ya plz fix rgb values omg my eyes
 *1/15	still not friday yet, I have the 2nd ap quiz in math and I am going to Die thank god they're curved
 *		 So I looked at the game design document. You still have to put "obligatory easter eggs" haha. Maybe put a frozen cheese on a table or something.
 *		 You should also really make an introduction/"how to play" screen (I guess just make another JFrame, press "h" for help)
 *		 Otherwise you're doing pretty well :)
*/
	
	
	/*PUZZLES - Please implement the necessary methods for these to work!!!!!!!!!!!!!!!!!!
	 * - The key to the door is under the door itself, so you have to find some kind of long stick/broom
	 * - There's a note behind the mirror that tells you this.
	 * - The mirror should have to be checked multiple times to find this (?) 
	 * - The dialogue for checking the "door" should change to the "what's that under the door" after the player has found the note.
	 * - One of the chests is locked. You have to find the key to the chest. Inside the chest is glue.
	 * - The key to that locked chest is inside the desk on the second floor.
	 * - The player needs to find three small sticks(tm). One is in a hole in the wall. It should be Very Hard to see (?)
	 * - After the player finds all three of the Small Sticks(tm), the Long Stick(tm) will be created and the player can escape.
	 * - There should be a small safe somewhere. There should also be a computer somewhere. Booting up the computer will tell the player a small clue about the code to the safe.
	 * - The safe should have a key for wherever one of the other Small Sticks(tm) are.
	 */
	
}
