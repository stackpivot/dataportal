/*
	* 	SDSC Matrix. A Gridflow Management System for data grids and digtal libraries
	*  Copyright (C) 2004 SDSC Matrix Project
	*
	* This library is free software; you can redistribute it and/or
	* modify it under the terms of the GNU Lesser General Public
	* License as published by the Free Software Foundation; either
	* version 2.1 of the License, or (at your option) any later version.
	*
	* This library is distributed in the hope that it will be useful,
	*	but WITHOUT ANY WARRANTY; without even the implied warranty of
	*	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
	*	Lesser General Public License for more details.
	*
	*	You should have received a copy of the GNU Lesser General Public
	*	License along with this library; if not, write to the Free Software
	*	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
	*
	* ====================================================================
	*
	* This software consists of voluntary contributions from the developers of the SDSC
	* Matrix Project. We request that all redistribution and software made using this code
	* acknowledge their use of the �SDSC Matrix project� in their end-user documentation or
	* in their website.
	*
	* SDSC Matrix Project (list of developers as of Dec 2005)
	*	Designer & Architect: Arun swaran Jagatheesan (arun@sdsc.edu)
	* 9500 Gilman Drive, MC0505
	* San Diego Supercomputer Center
	* University of California
	* La Jolla CA 92093
	*
	* Allen Ding (alding@sdsc.edu)
	* Lucas Gilbert (iktome@sdsc.edu)
	* Arun Jagatheesan (arun@sdsc.edu)
	* Reena Mathew	(rmathew@sdsc.edu)
	* Daniel Moore (mixx@umail.ucsb.edu)
	* Erik Vandekieft (evk@sdsc.edu)
	* Jonathan Weinberg (jonw@sdsc.edu)
	*
	*/


package edu.sdsc.matrix.srb.client;

/**
	* <p>Description: Client API to help developer create the
	* MetadataQuery steps instead going through lots of pain </p>
	* <p>Copyright: Copyright (c) 2003</p>
	* <p>Company: </p>
	* @author Arun swaran Jagatheesan
	* @version 1.0
	*/


public class MetadataQueryStep extends Step{

			public MetadataQueryStep(String id, String XQuery) {
						super (id, new Operation( new MetadataQueryOp ( new MetadataQueryParams ( XQuery))));
			}

			public MetadataQueryStep(String id, ParamList flexParams){
						super(id, new Operation (new MetadataQueryOp ( flexParams)));
			}

			public MetadataQueryStep(String id, MetadataQueryParams stdParams){
						super(id, new Operation (new MetadataQueryOp (stdParams)));
			}
}