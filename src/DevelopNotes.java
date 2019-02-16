
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
 *1/15	 still not friday yet, I have the 2nd ap quiz in math and I am going to Die thank god they're curved
 *		 So I looked at the game design document. You still have to put "obligatory easter eggs" haha. Maybe put a frozen cheese on a table or something.
 *		 You should also really make an introduction/"how to play" screen (I guess just make another JFrame, press "h" for help)
 *		 Otherwise you're doing pretty well :)
 *1/18	 alfonse dies in two days
 *		 Implemented help feature, Undertale easter egg, Ib drawing
 *		 Work on stuff mentioned above :)
 *1/25	 finals are finally EFFING over oh my god. cyl3 midterms are out and they Do Not Look Good. Fairy's Requiem (torays) came out today and ix looks so cute in his new outfit!!!! also NO SCHOOL HAHAHAHA
 *		 also I summoned nailah yesterday :)
 *		 A8ridged the Undertale easter egg. Actually put up the I8 drawing.
 *		 Put some kind of Homestuck reference in here. 8lease!!!!!!!!
 *		 Put the computer and safe in the game. The computer now changes color when checked. Need to implement this on other devices.
 *		 Please draw the chest. It's 8een green for so long.
 *		 Implement some kind of Small Stick.
 *		 Also there's a lagging problem, don't use the computer that you used last time. (The one closest to the door.) Also the frickin chicken chest doesn't want tO UNLOCK
 *		 Good luck on your presentation next time I guess haha
 *		 Apparently checking things multiple times adds multiple things to your inventory :(. Fix this!
 *		 Also add some kind of shrimp thing to your code, I guess.
 *2/1	 mmm cyl3 results mmm piranha plant mmm 7th camilla mmm new semester
 *		 in h0n0r 0f me reading h0mestuck i'll probably write these in quirk style because 1) why n0t and 2) i'll regret it later but it'll be fun n0w
 *		 the real questi0n is... h0w d0 i write in terezi's quirk
 *		 anyway, lag pr0blem is finally fixed!!! yay
 *		 start thinking ab0ut putting in s0und, als0 need t0 update fl00r because the rgb difference is driving me insane
 *		 the key pr0blem is finally fixed!!! except now the chest d0esn't want t0 check. :(
 *		 keep w0rking 0n the 0ther stuff menti0ned ab0ve, etc etc. als0 walk cycle!!! start w0rking 0n that
 *		 als0 uh. y0u can't check multiple times
 *2/8	 I forgot all the other quirks :) also uh feh 2nd anniversary week!
 *		 made a MUCH BETTER title screen
 *		 also the gigantic locking problem is ALSO FINISHED!! 
 *		 also the painting moved... a little bit
 *		 I made the "floorhmm.png" file. It's pretty... hmm. Crop it maybe
 *		 start investigating sound, walk cycles, and putting a more efficient safe/computer puzzle in.
 *2/15	 nintendo direct was the day before yesterday... three houses is a big oof. doesn't even look like a fe game except for purple smoky byleth at the end. it looks like persona???
 *		 also uh find and vote heroes was a big flop. winners are h!myrrh, lazura, l!lyn, and duma. I'm 99% sure I'm either getting lazura or l!lyn
 *		 implemented walk cycle!! now I just have to, uh, actually make them
 *		 added the song class in order to play music and stuff
 *		 I added an actual sky... but idk if I like it. also I fixed the floor? I guess it's fine? Idk still looks kinda weird
 *		 Update graphics... maybe do this at home or something where I don't have to mouse draw anything. Find templates for sprites bc I can't draw sprites to save my life
 *		 Start trying to put sounds!!
 *		 Added a bit of the puzzle portion. Check the mirror!
*/
	
	/*GRAPHICS THAT NEED TO BE UPDATED
	 * - desk
	 * - door
	 * - safe
	 * - sofa
	 * - stick (implement later) stick
	 * - character
	 */
	
	/*SOUNDS TO PUT IN THE GAME
	 * - opening various things (separate opening/closing door sound)
	 * - computer noises (some weird stereotypical computer beep beep noise)
	 * - some annoying music in the background 
	 * - don't put title music. that sucks
	 * - ending music? (like that music that plays when you beat "there is no game")
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
	
	//PSA: RGB value for the floor is #422d10. Darker color is #3b280e.
	//HEY IDEA: transition screens (black screens? or that weird slidey transition black screen? that one I doubt)
	
	//sky rgbs hmm
	/* - #bae2e8
	 * - #c1e4eb
	 * - #b1dce3
	 * - #a2d4db
	 */
	
	/*SMALL STICK IDEAS
	 * - Pencil
	 * - Pipe
	 * - An actual stick
	 * - Wire
	 */
	
}
