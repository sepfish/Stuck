
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
 *2/22	 it's japan cat day. also legendary roy was leaked, and I don't quite know what day it is. also keaton!! came home yesterday!! but he's +hp -spd :(
 *		 I tried looking for character sprites over the weekend and was unsuccessful. try looking on manyland.
 *		 I added another small stick!!! it's inside the sofa, and it's actually illustrated!!!
 *		 also the pgo in the decorator is supposed to be a perfectly generic object
 *3/1	 holy cow it's march also hrid the ice man came home also I asked my dad to check out the game and he found a few glitches also IT'S LIT FAM DABDABDAB DABDABDABDAB HASHTAG #SQUADGOALS
 *		 fixed a glitch where when you checked something the character kept moving
 *		 added some music!! just music though
 *		 I tested out the sprite and it works!! but I would, uh, crop it better.
 *		 added a message when your inventory has nothing in it, also added icons for the joptionpanes
 *		 I just added a sound to the computer, need to make sure that works
 *		 Add an icon for the computer, and start drawing "checked" images for sprites
 *		 ofc, add sound & puzzles. also add an instructions screen.
 *		 also start implementing how someone's actually going to get the key to the door in the first place. the key should go in the inventory and then the player can use it on the door
 *		 so there's now something called keyPieces that counts the number of key pieces the character has picked up - there should also be a boolean for if they picked up the glue
 *		 if the character has all three keyPieces AND the glue, then you can get the key
 *3/8	 RIP DADFONSE, also darkness whatever banner dropped today and I had 21 orbs :)
 *		 fixed the introduction glitch. now the game actually has an introduction!
 *		 also you can't move during the introduction, even if you press the arrow keys
 *		 also fixed (finally!) where if you pressed h or i during the title screen the window for either help or the inventory would pop up
 *		 it's now slightly harder to get to the ending through debugs.
 *		 added a method in the character that checks 1. if you have the glue and 2. if you have all three pieces and the glue
 *		 also made it possible (I guess) to open the door. except the player doesn't know that, do they
 *		 the music now stops when you open the door
 *		 next time: sound effects, making it possible for the player to open the safe and not just you
 *		 there's a commented-out line where you check the computer. make a "forgot password" option so that the player can guess the password. please don't just make it "password"
 *		 you're almost done!!! just keep going!!!
 *3/15	 we had a fun dance class today. that's the only interesting thing that happened
 *		 there is now a hint for the password. the password is now 123456. such a dumb password
 *		 there are still problems when you press cancel on the computer??? idk the game still runs but the console screams at you
 *		 I was using loadSound wrong like a dumdum :I so now the beep finally plays
 *		 it is now possible to actually win the game!!! now to make it look pretty
 *		 finally updated the frickin desk. might want to put a chair there? was too lazy to put one
 *		 I would try to add "check portraits"?? maybe? if there is time?
 *3/22	 bunny bruno is the newest male healer in like two years!! he explodes his shirt too! that sounds so weird out of context
 *		 two people tested the game. changed "most common password" to 12345
 *		 safe and computer have "cancel" inputpanel problems (they throw exceptions so can't compare). the guy said he'd tell me how to fix it next week
 *		 added safe graphics? idk they look weird
 *		 put in tales music?
 *3/29	 I got abs man. he is a brick wall of a troubadour.
 *		 null exceptions on safe and computer are fixed!
 *		 will work on the character in the near future because this game needs to be Done!!
 *		 Added check portraits to the chests FINALLy
 *		 added a chair :)
 *		 should add more graphics/sounds/a tales reference
 *		 maybe make it so that the combination to the safe is randomly generated
 *4/5	 finals are done!! the feh channel yesterday sucked. rip my chances of getting gen 1 units.
 *		 made it so the combination to the safe is randomly generated
 *		 added a door key! you forgot about that
 *		 added Delight In Victory - Tales of Xillia OST Extended (dooooo doodoodoodoo doodoodoo doodoo da doodoodoodoo da doo doo da doo)
 *		 added stairs
 *4/5 part 2: please rescue the character files from the main build path thanks
 *4/7	 makeup lab :) also spring xander came home for some odd reason. all I was doing was yolo summoning. whatever I'm not complaining
 *		 added character sprite portraits. MOST OF THEM. forgot the ones for walking down stairs >:( they look kinda sloppy but eh. 
 *		 left1.png is also messed up whoops haha
 *		 the first room is kinda grayish maybe add some ~color~
 *		 the side table... is not checking?? my brain is fried rn so I can't figure out why
 *		 safe's key is now called "forgotten key" to clear up the misunderstanding about the Other Chest and the Other Key
 *		 the help thing was wrong... ugh... so now press enter to check
 *		 this is more of a preference thing... but doing the "inbetween" sprites of the character would probably help it ~flow~ better
 *		 mirror is updated!
 *		 added a picture frame on floor 2 but haven't drawn it yet. draw it next time I guess
 *		 lamp looks kinda sketchy but that's ok. maybe move the clock a little bit
 *		 once you fix the side table, you'll be pretty much done!! how bout that
 *		 Made it so that you can't see the key under the door unless you accept the note from the mirror
 *		 Made the walking speed sliiiiightly faster.
 *		 Made the character sliiiightly bigger (63x84 instead of 60x80). Idk if this screwed with the "hitboxes" though. It definitely showcased my terrible editing skills haha
 *		 Removed some unneccesary code.
 *4/7 part 2: added fixed character portraits.
 *4/19	 JOKER STEALS THE SHOW AND ALSO CRASHES NINTENDO'S SERVERS!! ranulf finally came home oh my god and flora is the bane of my existence yet again
 *		 finally graphics are as done as they can be honestly. I'm tired of making them :(
 *		 added sound when you walk up stairs? I sure hope that works
 *		 so the side table isn't checking because it's too small... ha ha I'll just leave that
 *		 made memory actually loop. apparently it didn't before.
 *		 changed the password... back to password... and made the hint easier
 *		 made that "eeee" sound play slightly more often
 *		 the drawer on the locked chest won't open unless it's unlocked
 *		 made the check "hitboxes" 20px wider
*/
	// IMPORTANT!!!! YOU NOW HAVE TO PRESS ENTER TO CHECK. UNLESS YOU WANT TO DRAW THE ENTIRE HELP THING AGAIN. 
	// PLEASE DON'T PRESS SPACE AND WONDER WHY IT ISN'T WORKING
	
	/*GRAPHICS THAT NEED TO BE UPDATED
	 * - door
	 * - character
	 * - clock
	 */
	
	//3.15.19: possible to win the game
	
	/*SOUNDS TO PUT IN THE GAME http://bit.ly/javazoom should be in the default package anyway but just in case
	 * - opening various things (separate opening/closing door sound)
	 *	 - https://freesound.org/people/InspectorJ/sounds/411791/ (close)
	 * - computer noises (some weird stereotypical computer beep beep noise)
	 * 	 - https://freesound.org/people/the_semen_incident/sounds/39013/ (beep)
	 * - some annoying music in the background 
	 * 	 - https://soundcloud.com/pianissimo818/ib-ost-memory-piano-ver - DONE!!
	 * - ending music? (like that music that plays when you beat "there is no game")
	 * 	 - chaos (ablaze) - DONE!!
	 */
	
	//PSA: RGB value for the floor is #422d10. Darker color is #3b280e.
	//ALSO media palace is here: https://github.com/League-Level1-Student/level1-module4-sepfish/blob/master/src/MediaPalace.java
	
	//sky rgbs hmm
	/* - #bae2e8
	 * - #c1e4eb
	 * - #b1dce3
	 * - #a2d4db
	 */
}
