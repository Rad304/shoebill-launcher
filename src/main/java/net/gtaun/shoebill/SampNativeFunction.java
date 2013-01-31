/**
 * Copyright (C) 2011 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gtaun.shoebill;

import java.io.File;

/**
 * 
 * 
 * @author MK124
 */
public final class SampNativeFunction
{
	private static final String LIBRARY_PATH = "plugins/";
	private static final String LIBRARY_NAME = "Shoebill";
	
	public static void loadLibrary()
	{
		File libraryDll = new File(LIBRARY_PATH + LIBRARY_NAME + ".dll");
		File librarySo  = new File(LIBRARY_PATH + LIBRARY_NAME);
		
		try
		{
			if (libraryDll.exists()) System.load(libraryDll.getAbsolutePath());
			else throw new UnsatisfiedLinkError();
		}
		catch (UnsatisfiedLinkError e)
		{
			if (librarySo.exists()) System.load(librarySo.getAbsolutePath());
			else throw e;
		}
	}
	
	
	// ----------------------------------------------------------
	// Custom
	
	public static native void setServerCodepage(int codepage);
	public static native int getServerCodepage();
	
	public static native void setPlayerCodepage(int playerid, int codepage);
	public static native int getPlayerCodepage(int playerid);
	
	// ----------------------------------------------------------
	// a_objects.inc
	
	public static native int createObject(int modelid, float x, float y, float z, float rX, float rY, float rZ, float drawDistance);
	public static native void attachObjectToVehicle(int objectid, int vehicleid, float x, float y, float z, float rX, float rY, float rZ);
	public static native void attachObjectToObject(int objectid, int attachtoid, float offsetX, float offsetY, float offsetZ, float rotX, float rotY, float rotZ, int syncRotation);
	public static native void attachObjectToPlayer(int objectid, int playerid, float offsetX, float offsetY, float offsetZ, float rX, float rY, float rZ);
	public static native void setObjectPos(int objectid, float x, float y, float z);
	public static native void getObjectPos(int objectid, Object rot);
	public static native void setObjectRot(int objectid, float rotX, float rotY, float rotZ);
	public static native void getObjectRot(int objectid, Object rot);
	public static native boolean isValidObject(int objectid);
	public static native void destroyObject(int objectid);
	public static native int moveObject(int objectid, float x, float y, float z, float speed, float rotX, float rotY, float rotZ);
	public static native void stopObject(int objectid);
	public static native boolean isObjectMoving(int objectid);
	public static native boolean editObject(int playerid, int objectid);
	public static native boolean editPlayerObject(int playerid, int objectid);
	public static native void selectObject(int playerid);
	public static native void cancelEdit(int playerid);
	public static native int createPlayerObject(int playerid, int modelid, float x, float y, float z, float rX, float rY, float rZ, float drawDistance);
	public static native void attachPlayerObjectToVehicle(int playerid, int objectid, int vehicleid, float fOffsetX, float fOffsetY, float fOffsetZ, float fRotX, float fRotY, float fRotZ);
	public static native void setPlayerObjectPos(int playerid, int objectid, float x, float y, float z);
	public static native void getPlayerObjectPos(int playerid, int objectid, Object rot);
	public static native void setPlayerObjectRot(int playerid, int objectid, float rotX, float rotY, float rotZ);
	public static native void getPlayerObjectRot(int playerid, int objectid, Object rot);
	public static native boolean isValidPlayerObject(int playerid, int objectid);
	public static native void destroyPlayerObject(int playerid, int objectid);
	public static native int movePlayerObject(int playerid, int objectid, float x, float y, float z, float speed, float rotX, float rotY, float rotZ);
	public static native void stopPlayerObject(int playerid, int objectid);
	public static native boolean isPlayerObjectMoving(int playerid, int objectid);
	public static native void attachPlayerObjectToPlayer(int playerid, int objectid, int attachplayerid, float offsetX, float offsetY, float offsetZ, float rX, float rY, float rZ);
	
	public static native void setObjectMaterial(int objectid, int materialindex, int modelid, String txdname, String texturename, int materialcolor);
	public static native void setPlayerObjectMaterial(int playerid, int objectid, int materialindex, int modelid, String txdname, String texturename, int materialcolor);

	public static native void setObjectMaterialText(int objectid, String text, int materialindex, int materialsize, String fontface, int fontsize, int bold, int fontcolor, int backcolor, int textalignment);
	public static native void setPlayerObjectMaterialText(int playerid, int objectid, String text, int materialindex, int materialsize, String fontface, int fontsize, int bold, int fontcolor, int backcolor, int textalignment);
	
	// ----------------------------------------------------------
	// a_players.inc
	
	// Player
	public static native void setSpawnInfo(int playerid, int teamid, int skinid, float x, float y, float z, float rotation, int weapon1, int weapon1_ammo, int weapon2, int weapon2_ammo, int weapon3, int weapon3_ammo);
	public static native void spawnPlayer(int playerid);
	
	// Player info
	public static native void setPlayerPos(int playerid, float x, float y, float z);
	public static native void setPlayerPosFindZ(int playerid, float x, float y, float z);
	public static native void getPlayerPos(int playerid, Object location);
	public static native void setPlayerFacingAngle(int playerid, float angle);
	public static native float getPlayerFacingAngle(int playerid);
	public static native boolean isPlayerInRangeOfPoint(int playerid, float range, float x, float y, float z);
	public static native boolean isPlayerStreamedIn(int playerid, int forplayerid);
	public static native void setPlayerInterior(int playerid, int interiorid);
	public static native int getPlayerInterior(int playerid);
	public static native void setPlayerHealth(int playerid, float health);
	public native static float getPlayerHealth(int playerid);
	public static native void setPlayerArmour(int playerid, float armour);
	public static native float getPlayerArmour(int playerid);
	public static native void setPlayerAmmo(int playerid, int weaponslot, int ammo);
	public static native int getPlayerAmmo(int playerid);
	public static native int getPlayerWeaponState(int playerid);
	public static native int getPlayerTargetPlayer(int playerid);
	public static native void setPlayerTeam(int playerid, int teamid);
	public static native int getPlayerTeam(int playerid);
	public static native void setPlayerScore(int playerid, int score);
	public static native int getPlayerScore(int playerid);
	public static native int getPlayerDrunkLevel(int playerid);
	public static native void setPlayerDrunkLevel(int playerid, int level);
	public static native void setPlayerColor(int playerid, int color);
	public static native int getPlayerColor(int playerid);
	public static native void setPlayerSkin(int playerid, int skinid);
	public static native int getPlayerSkin(int playerid);
	public static native void givePlayerWeapon(int playerid, int weaponid, int ammo);
	public static native void resetPlayerWeapons(int playerid);
	public static native void setPlayerArmedWeapon(int playerid, int weaponid);
	public static native void getPlayerWeaponData(int playerid, int slot, Object weapondata);
	public static native void givePlayerMoney(int playerid, int money);
	public static native void resetPlayerMoney(int playerid);
	public static native int setPlayerName(int playerid, String name);
	public static native int getPlayerMoney(int playerid);
	public static native int getPlayerState(int playerid);
	public static native String getPlayerIp(int playerid);
	public static native int getPlayerPing(int playerid);
	public static native int getPlayerWeapon(int playerid);
	public static native void getPlayerKeys(int playerid, Object keystate);
	public static native String getPlayerName(int playerid);
	public static native void setPlayerTime(int playerid, int hour, int minute);
	public static native void getPlayerTime(int playerid, Object time);
	public static native void togglePlayerClock(int playerid, boolean toggle);
	public static native void setPlayerWeather(int playerid, int weather);
	public static native void forceClassSelection(int playerid);
	public static native void setPlayerWantedLevel(int playerid, int level);
	public static native int getPlayerWantedLevel(int playerid);
	public static native void setPlayerFightingStyle(int playerid, int style);
	public static native int getPlayerFightingStyle(int playerid);
	public static native void setPlayerVelocity(int playerid, float x, float y, float z);
	public static native void getPlayerVelocity(int playerid, Object velocity);
	public static native void playCrimeReportForPlayer(int playerid, int suspectid, int crime);
	public static native void playAudioStreamForPlayer(int playerid, String url, float posX, float posY, float posZ, float distance, int usepos);
	public static native void stopAudioStreamForPlayer(int playerid);
	public static native void setPlayerShopName(int playerid, String shopname);
	public static native void setPlayerSkillLevel(int playerid, int skill, int level);
	public static native int getPlayerSurfingVehicleID(int playerid);
	public static native int getPlayerSurfingObjectID(int playerid);
	public static native void removeBuildingForPlayer(int playerid, int modelid, float x, float y, float z, float radius);
	
	// Attached to bone objects
	public static native boolean setPlayerAttachedObject(int playerid, int index, int modelid, int bone, float offsetX, float offsetY, float offsetZ, float rotX, float rotY, float rotZ, float scaleX, float scaleY, float scaleZ, int materialcolor1, int materialcolor2);
	public static native boolean removePlayerAttachedObject(int playerid, int index);
	public static native boolean isPlayerAttachedObjectSlotUsed(int playerid, int index);
	public static native boolean editAttachedObject(int playerid, int index);
	
	// Per-player TextDraws
	public static native int createPlayerTextDraw(int playerid, float x, float y, String text);
	public static native void playerTextDrawDestroy(int playerid, int textId);
	public static native void playerTextDrawLetterSize(int playerid, int textId, float x, float y);
	public static native void playerTextDrawTextSize(int playerid, int textId, float x, float y);
	public static native void playerTextDrawAlignment(int playerid, int textId, int alignment);
	public static native void playerTextDrawColor(int playerid, int textId, int color);
	public static native void playerTextDrawUseBox(int playerid, int textId, int use);
	public static native void playerTextDrawBoxColor(int playerid, int textId, int color);
	public static native void playerTextDrawSetShadow(int playerid, int textId, int size);
	public static native void playerTextDrawSetOutline(int playerid, int textId, int size);
	public static native void playerTextDrawBackgroundColor(int playerid, int textId, int color);
	public static native void playerTextDrawFont(int playerid, int textId, int font);
	public static native void playerTextDrawSetProportional(int playerid, int textId, int set);
	public static native void playerTextDrawSetSelectable(int playerid, int textId, int set);
	public static native void playerTextDrawShow(int playerid, int textId);
	public static native void playerTextDrawHide(int playerid, int textId);
	public static native void playerTextDrawSetString(int playerid, int textId, String string);
	public static native void playerTextDrawSetPreviewModel(int playerid, String text, int modelindex);
	public static native void playerTextDrawSetPreviewRot(int playerid, String text, float fRotX, float fRotY, float fRotZ, float fZoom);
	public static native void playerTextDrawSetPreviewVehCol(int playerid, String text, int color1, int color2);

	// Per-player variable system (PVars)
	public static native void setPVarInt(int playerid, String varname, int int_value);
	public static native int getPVarInt(int playerid, String varname);
	public static native void setPVarString(int playerid, String varname, String string_value);
	public static native String getPVarString(int playerid, String varname);
	public static native void setPVarFloat(int playerid, String varname, float float_value);
	public static native float getPVarFloat(int playerid, String varname);
	public static native int deletePVar(int playerid, String varname);
	
	public static native int getPVarsUpperIndex(int playerid);
	public static native String getPVarNameAtIndex(int playerid, int index);
	public static native int getPVarType(int playerid, String varname);
	
	// Chat Bubble
	public static native void setPlayerChatBubble(int playerid, String text, int color, float drawdistance, int expiretime);
	
	// Player controls
	public static native void putPlayerInVehicle(int playerid, int vehicleid, int seatid);
	public static native int getPlayerVehicleID(int playerid);
	public static native int getPlayerVehicleSeat(int playerid);
	public static native void removePlayerFromVehicle(int playerid);
	public static native void togglePlayerControllable(int playerid, boolean toggle);
	public static native void playerPlaySound(int playerid, int soundid, float x, float y, float z);
	public static native void applyAnimation(int playerid, String animlib, String animname, float delta, int loop, int lockX, int lockY, int freeze, int time, int forcesync);
	public static native void clearAnimations(int playerid, int forcesync);
	public static native int getPlayerAnimationIndex(int playerid); // return the index of any running applied animations (0 if none are running)
	// public static native int getAnimationName(int index, String animlib, int len1, String animname, int len2); // get the animation lib/name for the
	public static native int getPlayerSpecialAction(int playerid);
	public static native void setPlayerSpecialAction(int playerid, int actionid);
	
	// Player world/map related
	public static native void setPlayerCheckpoint(int playerid, float x, float y, float z, float size);
	public static native void disablePlayerCheckpoint(int playerid);
	public static native void setPlayerRaceCheckpoint(int playerid, int type, float x, float y, float z, float nextX, float nextY, float nextZ, float size);
	public static native void disablePlayerRaceCheckpoint(int playerid);
	public static native void setPlayerWorldBounds(int playerid, float x_max, float x_min, float y_max, float y_min);
	public static native void setPlayerMarkerForPlayer(int playerid, int showplayerid, int color);
	public static native void showPlayerNameTagForPlayer(int playerid, int showplayerid, boolean show);
	
	public static native void setPlayerMapIcon(int playerid, int iconid, float x, float y, float z, int markertype, int color, int style);
	public static native void removePlayerMapIcon(int playerid, int iconid);
	
	// Player camera
	public static native void setPlayerCameraPos(int playerid, float x, float y, float z);
	public static native void setPlayerCameraLookAt(int playerid, float x, float y, float z, int cut);
	public static native void setCameraBehindPlayer(int playerid);
	public static native void getPlayerCameraPos(int playerid, Object location);
	public static native void getPlayerCameraFrontVector(int playerid, Object location);
	public static native int getPlayerCameraMode(int playerid);
	public static native void attachCameraToObject(int playerid, int objectid);
	public static native void attachCameraToPlayerObject(int playerid, int playerobjectid);
	public static native void interpolateCameraPos(int playerid, float FromX, float FromY, float FromZ, float ToX, float ToY, float ToZ, int time, int cut);
	public static native void interpolateCameraLookAt(int playerid, float FromX, float FromY, float FromZ, float ToX, float ToY, float ToZ, int time, int cut);

	// Player conditionals
	public static native boolean isPlayerConnected(int playerid);
	public static native boolean isPlayerInVehicle(int playerid, int vehicleid);
	public static native boolean isPlayerInAnyVehicle(int playerid);
	public static native boolean isPlayerInCheckpoint(int playerid);
	public static native boolean isPlayerInRaceCheckpoint(int playerid);
	
	// Virtual Worlds
	public static native void setPlayerVirtualWorld(int playerid, int worldid);
	public static native int getPlayerVirtualWorld(int playerid);
	
	// Insane Stunts
	public static native void enableStuntBonusForPlayer(int playerid, int enabled);
	public static native void enableStuntBonusForAll(boolean enabled);
	
	// Spectating
	public static native void togglePlayerSpectating(int playerid, boolean toggle);
	public static native void playerSpectatePlayer(int playerid, int targetplayerid, int mode);
	public static native void playerSpectateVehicle(int playerid, int targetvehicleid, int mode);
	
	// Recording for NPC playback
	public static native void startRecordingPlayerData(int playerid, int recordtype, String recordname);
	public static native void stopRecordingPlayerData(int playerid);
	
	public static native void selectTextDraw(int playerid, int hovercolor); // enables the mouse so the player can select a textdraw
	public static native void cancelSelectTextDraw(int playerid);	// cancel textdraw selection with the mouse
	
	// ----------------------------------------------------------
	// a_samp.inc
	
	// Util
	public static native void sendClientMessage(int playerid, int color, String message);
	public static native void sendClientMessageToAll(int color, String message);
	public static native void sendPlayerMessageToPlayer(int playerid, int senderid, String message);
	public static native void sendPlayerMessageToAll(int senderid, String message);
	public static native void sendDeathMessage(int killerid, int victimid, int reason);
	public static native void gameTextForAll(String string, int time, int style);
	public static native void gameTextForPlayer(int playerid, String string, int time, int style);
	public static native int setTimer(int index, int interval, int repeating);
	public static native void killTimer(int timerid);
	public static native int getMaxPlayers();
	
	// Game
	public static native void setGameModeText(String string);
	public static native void setTeamCount(int count);
	public static native int addPlayerClass(int modelid, float spawn_x, float spawn_y, float spawn_z, float z_angle, int weapon1, int weapon1_ammo, int weapon2, int weapon2_ammo, int weapon3, int weapon3_ammo);
	public static native int addPlayerClassEx(int teamid, int modelid, float spawn_x, float spawn_y, float spawn_z, float z_angle, int weapon1, int weapon1_ammo, int weapon2, int weapon2_ammo, int weapon3, int weapon3_ammo);
	public static native int addStaticVehicle(int modelid, float spawn_x, float spawn_y, float spawn_z, float z_angle, int color1, int color2);
	public static native int addStaticVehicleEx(int modelid, float spawn_x, float spawn_y, float spawn_z, float z_angle, int color1, int color2, int respawn_delay);
	public static native int addStaticPickup(int model, int type, float x, float y, float z, int virtualWorld);
	public static native int createPickup(int model, int type, float x, float y, float z, int virtualWorld);
	public static native void destroyPickup(int pickup);
	public static native void showNameTags(boolean enabled);
	public static native void showPlayerMarkers(int mode);
	public static native void gameModeExit();
	public static native void setWorldTime(int hour);
	public static native String getWeaponName(int weaponid);
	public static native void enableTirePopping(boolean enabled);
	public static native void enableVehicleFriendlyFire();
	public static native void allowInteriorWeapons(boolean allow);
	public static native void setWeather(int weatherid);
	public static native void setGravity(float gravity);
	public static native void setDeathDropAmount(int amount);
	public static native void createExplosion(float x, float y, float z, int type, float radius);
	public static native void enableZoneNames(boolean enabled);
	public static native void usePlayerPedAnims();
	public static native void disableInteriorEnterExits();
	public static native void setNameTagDrawDistance(float distance);
	public static native void disableNameTagLOS();
	public static native void limitGlobalChatRadius(float chat_radius);
	public static native void limitPlayerMarkerRadius(float marker_radius);
	
	// Npc
	public static native void connectNPC(String name, String script);
	public static native boolean isPlayerNPC(int playerid);
	
	// Admin
	public static native boolean isPlayerAdmin(int playerid);
	public static native void kick(int playerid);
	public static native void ban(int playerid);
	public static native void banEx(int playerid, String reason);
	public static native void sendRconCommand(String cmd);
	public native static String getServerVarAsString(String varname);
	public static native int getServerVarAsInt(String varname);
	public static native boolean getServerVarAsBool(String varname);
	public static native String getPlayerNetworkStats(int playerid);
	public static native String getNetworkStats();
	public static native String getPlayerVersion(int playerid); // Returns the SA-MP client revision as reported by the player

	// Menu
	public static native int createMenu(String title, int columns, float x, float y, float col1width, float col2width);
	public static native void destroyMenu(int menuid);
	public static native void addMenuItem(int menuid, int column, String menutext);
	public static native void setMenuColumnHeader(int menuid, int column, String columnheader);
	public static native void showMenuForPlayer(int menuid, int playerid);
	public static native void hideMenuForPlayer(int menuid, int playerid);
	public static native boolean isValidMenu(int menuid);
	public static native void disableMenu(int menuid);
	public static native void disableMenuRow(int menuid, int row);
	public static native int getPlayerMenu(int playerid);
	
	// Text Draw
	public static native int textDrawCreate(float x, float y, String text);
	public static native void textDrawDestroy(int textid);
	public static native void textDrawLetterSize(int textid, float x, float y);
	public static native void textDrawTextSize(int textid, float x, float y);
	public static native void textDrawAlignment(int textid, int alignment);
	public static native void textDrawColor(int textid, int color);
	public static native void textDrawUseBox(int textid, boolean use);
	public static native void textDrawBoxColor(int textid, int color);
	public static native void textDrawSetShadow(int textid, int size);
	public static native void textDrawSetOutline(int textid, int size);
	public static native void textDrawBackgroundColor(int textid, int color);
	public static native void textDrawFont(int textid, int font);
	public static native void textDrawSetProportional(int textid, int set);
	public static native void textDrawSetSelectable(int textid, int set);
	public static native void textDrawShowForPlayer(int playerid, int textid);
	public static native void textDrawHideForPlayer(int playerid, int textid);
	public static native void textDrawShowForAll(int textid);
	public static native void textDrawHideForAll(int textid);
	public static native void textDrawSetString(int textid, String string);
	public static native void textDrawSetPreviewModel(String text, int modelindex);
	public static native void textDrawSetPreviewRot(String text, float fRotX, float fRotY, float fRotZ, float fZoom);
	public static native void textDrawSetPreviewVehCol(String text, int color1, int color2);

	// Gang Zones
	public static native int gangZoneCreate(float minx, float miny, float maxx, float maxy);
	public static native void gangZoneDestroy(int zoneid);
	public static native void gangZoneShowForPlayer(int playerid, int zoneid, int color);
	public static native void gangZoneShowForAll(int zoneid, int color);
	public static native void gangZoneHideForPlayer(int playerid, int zoneid);
	public static native void gangZoneHideForAll(int zoneid);
	public static native void gangZoneFlashForPlayer(int playerid, int zoneid, int flashcolor);
	public static native void gangZoneFlashForAll(int zoneid, int flashcolor);
	public static native void gangZoneStopFlashForPlayer(int playerid, int zoneid);
	public static native void gangZoneStopFlashForAll(int zoneid);
	
	// Global 3D Text Labels
	public static native int create3DTextLabel(String text, int color, float x, float y, float z, float drawDistance, int worldid, boolean testLOS);
	public static native void delete3DTextLabel(int id);
	public static native void attach3DTextLabelToPlayer(int id, int playerid, float offsetX, float offsetY, float offsetZ);
	public static native void attach3DTextLabelToVehicle(int id, int vehicleid, float offsetX, float offsetY, float offsetZ);
	public static native void update3DTextLabelText(int id, int color, String text);
	
	// Per-player 3D Text Labels
	public static native int createPlayer3DTextLabel(int playerid, String text, int color, float x, float y, float z, float drawDistance, int attachedplayerid, int attachedvehicleid, boolean testLOS);
	public static native void deletePlayer3DTextLabel(int playerid, int id);
	public static native void updatePlayer3DTextLabelText(int playerid, int id, int color, String text);
	
	// Player GUI Dialog
	public static native int showPlayerDialog(int playerid, int dialogid, int style, String caption, String info, String button1, String button2);
	
	// ----------------------------------------------------------
	// a_vehicles.inc
	
	// Vehicle
	public static native int createVehicle(int model, float x, float y, float z, float rotation, int color1, int color2, int respawnDelay);
	public static native void destroyVehicle(int vehicleid);
	public static native boolean isVehicleStreamedIn(int vehicleid, int forplayerid);
	public static native void getVehiclePos(int vehicleid, Object location);
	public static native void setVehiclePos(int vehicleid, float x, float y, float z);
	public static native float getVehicleZAngle(int vehicleid);
	public static native void getVehicleRotationQuat(int vehicleid, Object quaternions);
	public static native void setVehicleZAngle(int vehicleid, float angle);
	public static native void setVehicleParamsForPlayer(int vehicleid, int playerid, boolean objective, boolean doorslocked);
	public static native void manualVehicleEngineAndLights();
	public static native void setVehicleParamsEx(int vehicleid, int engine, int lights, int alarm, int doors, int bonnet, int boot, int objective);
	public static native void getVehicleParamsEx(int vehicleid, Object state);
	public static native void setVehicleToRespawn(int vehicleid);
	public static native void linkVehicleToInterior(int vehicleid, int interiorid);
	public static native void addVehicleComponent(int vehicleid, int componentid);
	public static native void removeVehicleComponent(int vehicleid, int componentid);
	public static native void changeVehicleColor(int vehicleid, int color1, int color2);
	public static native void changeVehiclePaintjob(int vehicleid, int paintjobid);
	public static native void setVehicleHealth(int vehicleid, float health);
	public static native float getVehicleHealth(int vehicleid);
	public static native void attachTrailerToVehicle(int trailerid, int vehicleid);
	public static native void detachTrailerFromVehicle(int vehicleid);
	public static native boolean isTrailerAttachedToVehicle(int vehicleid);
	public static native int getVehicleTrailer(int vehicleid);
	public static native void setVehicleNumberPlate(int vehicleid, String numberplate);
	public static native int getVehicleModel(int vehicleid);
	public static native int getVehicleComponentInSlot(int vehicleid, int slot); // There is 1 slot for each CARMODTYPE_*
	public static native int getVehicleComponentType(int component); // Find CARMODTYPE_* for component id
	public static native void repairVehicle(int vehicleid); // Repairs the damage model and resets the health
	
	public static native void getVehicleVelocity(int vehicleid, Object velocity);
	public static native void setVehicleVelocity(int vehicleid, float x, float y, float z);
	public static native void setVehicleAngularVelocity(int vehicleid, float x, float y, float z);
	public static native void getVehicleDamageStatus(int vehicleid, Object damage);
	public static native void updateVehicleDamageStatus(int vehicleid, int panels, int doors, int lights, int tires);
	
	public static native void getVehicleModelInfo(int vehiclemodel, int infotype, Object vector);
	
	// Virtual Worlds
	public static native void setVehicleVirtualWorld(int vehicleid, int worldid);
	public static native int getVehicleVirtualWorld(int vehicleid);
}