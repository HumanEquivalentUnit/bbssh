/*
 *  Copyright (C) 2010 Marc A. Paradise
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.bbssh.command;

import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Status;

import org.bbssh.keybinding.ExecutableCommand;
import org.bbssh.session.RemoteSessionInstance;
import org.bbssh.ui.screens.ActiveSessionList;

/**
 * This command displays a menbu of active sessions. It will switch the presented terminal with the selected terminal
 */
public class ListSessions extends ExecutableCommand {
	public int getId() {
		return CommandConstants.LIST_SESSIONS;
	}

	public boolean execute(RemoteSessionInstance current, Object parameter) {
		// Dynamically build the list of connected sessions
		ActiveSessionList list = new ActiveSessionList();
		if (list.getNumSessions() > 0) {
			UiApplication.getUiApplication().pushModalScreen(list);
		} else {
			Status.show(res.getString(MSG_NO_OTHER_SESSION_CONNECTED));
		}
		return true;
	}

	public int getNameResId() {
		return CMD_NAME_LIST_SESSIONS;
	}

	public int getDescriptionResId() {
		return CMD_DESC_LIST_SESSIONS;
	}

	public boolean isKeyBindable() {
		return true;
	}

	public boolean isParameterRequired() {
		return false;
	}

	public boolean isMacroAction() {
		return false;
	}

	public boolean isConnectionRequired() {
		return false;
	}

	public boolean isUILockRequired() {
		return true;
	}
}
