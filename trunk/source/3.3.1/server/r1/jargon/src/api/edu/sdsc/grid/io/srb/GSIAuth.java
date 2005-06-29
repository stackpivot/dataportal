//
//	Copyright (c) 2003  San Diego Supercomputer Center (SDSC),
//	University of California, San Diego (UCSD), San Diego, CA, USA.
//
//	Users and possessors of this source code are hereby granted a
//	nonexclusive, royalty-free copyright and design patent license
//	to use this code in individual software.  License is not granted
//	for commercial resale, in whole or in part, without prior written
//	permission from SDSC/UCSD.  This source is provided "AS IS"
//	without express or implied warranty of any kind.
//
//
//  FILE
//	SRBCommands.java	-  edu.sdsc.grid.io.srb.SRBCommands
//
//  CLASS HIERARCHY
//	java.lang.Object
//     |
//     +-.SRBCommands
//
//  PRINCIPAL AUTHOR
//	Lucas Gilbert, SDSC/UCSD
//
//
package edu.sdsc.grid.io.srb;

import edu.sdsc.grid.io.*;
import edu.sdsc.grid.io.local.*;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Does nothing. This is the fake GSIAuth class.
 * If you do not have the GSI libraries, (Which should be available at
 * the JARGON website) overwrite GSIAuth.java with this file.
 *<P>
 * This class will allow you to compile the Jargon code without those
 * libraries. All functionality of Jargon, besides GSI authentication,
 * will still be available.
 *
 * @author	Lucas Gilbert, San Diego Supercomputer Center
 */
class GSIAuth
{
//----------------------------------------------------------------------
//  Constants
//----------------------------------------------------------------------





//----------------------------------------------------------------------
//  Fields
//----------------------------------------------------------------------




//----------------------------------------------------------------------
//  Constructors and Destructors
//----------------------------------------------------------------------
	/**
	 * Checks the authentication using GSI of a SRB connection which has already
	 * passed the uner info part of the handshake.
	 *<P>
	 * @param password The directory to find the proxy file.
	 * @param caLocations The directory to find the CA file(s).
	 * @param srbConnection The open socket to the SRB.
	 * @param out The output stream from that socket.
	 * @param in The input stream from that socket.
	 * @throws IOException If the authentication to the SRB fails.
	 */
	GSIAuth( String password, String caLocations, Socket srbConnection,
		OutputStream out, InputStream in )
		throws IOException
	{
		//This is the fake GSIAuth class.
		throw new UnsupportedOperationException("This version of Jargon "+
			"has been compiled without the GSI libraries");
	}




//----------------------------------------------------------------------
// Methods
//----------------------------------------------------------------------
}
// End GSIAuth-----