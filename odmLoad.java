/* Copyright (C) 2000-2021. Stephen Lawrence
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/*
 * Bootstrap file for setting the ABSPATH constant
 * and loading the config.php file. The config.php
 * file will then load the odm-init.php file, which
 * will then set up the OpenDocMan environment.
 *
 * If the config.php file is not found then an error
 * will be displayed asking the visitor to set up the
 * config.php file.
 *
 * Will also search for config.php in OpenDocMans' parent
 * directory to allow the OpenDocMan directory to remain
 * untouched.
 *
 */

import java.io.File;
public class odmLoad {
	
	public static void main(String[] args) {

		String ABSPATH;
		File path = null;
		
		try {
		if(new File("config.php").exists()) {
			// In the case of root folder calls
			path = new File("config.php");		
		}
			
		else if (new File("docker-configs/config.php").exists()) {
			// In case we are running from Docker
			path = new File("docker-configs/config.php");			
		}
		
		else if (new File("../config.php").exists()) {
			// In the case of subfolders
			path = new File("../config.php");
		} 
		
		else if (new File("../../config.php").exists()) {
			// In the case of plugins
			path = new File("../../config.php");	
		}
		ABSPATH = path.getAbsolutePath();
		System.out.println(ABSPATH);
		} catch(Exception e) {
			System.out.println("File not found - Please manually set up config.php file using the example_config.php template.");
		}
	}
}