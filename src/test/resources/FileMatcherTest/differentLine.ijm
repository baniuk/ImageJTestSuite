/**
 * Add scale bars to images generated by Matlab script
 * %% Get slices for max of hausdorf
 * 
 * Images to process must be in ../graphics folder and have pattern
 * A(ac|rw)_combinedRGB_Hmaxframe.tif
 */

d=getDirectory("Choose a Directory where GoldenSeg folder is");
d1=getDirectory("Choose a Directory where graphics are");


addBa("C1-talA_GFP_rnd_motility_FLU",d,d1,"E");
addBar("C1-talA_mNeon_2pct_bleb_Image39_FLU",d,d1,"A");
addBar("C1-talA_mNeon_2pct_bleb_Image40",d,d1,"B");
addBar("C1-talA_mNeon_bleb_0pt7pctagar_FLU",d,d1,"D");
addBar("July09ABD_GFP_actin_rnd_motility",d,d1,"F");
addBar("July14ABD_GFP_actin_1pctagar",d,d1,"G");
addBar("C1-talA_mNeon_2pct_bleb_Image40_2",d,d1,"C");


/**
 * Add scale bar to frame with max Hausdorff.
 * 
 * Frame must be in relative dir to d = ../graphics and have naming
 * codename(ac|rw)_combinedRGB_Hmaxframe.tif
 * 
 * Assume that gold case has set correct scale
 */
function addBar(caseg, d, d1,codename) {
	print("process " + caseg);
	gold = d+File.separator+"GoldenSeg"+File.separator+caseg+File.separator+caseg+".tif";

	setBatchMode(true);
	open(gold);
	gID = getImageID();
	run("Set Scale...", "known=1 pixel=1 unit=µm global");

	frame = ".."+File.separator+"graphics"+File.separator+codename+"ac_combinedRGB_Hmaxframe.tif";
	open(frame);
	imID = getImageID();
	run("Scale Bar...", "width=10 height=2 font=12 color=White background=Black location=[Upper Right] bold");
	saveAs("PNG",d1+File.separator+codename+"ac_combinedRGB_Hmaxframe.tif.png");
	selectImage(imID);
	close();

	frame = ".."+File.separator+"graphics"+File.separator+codename+"rw_combinedRGB_Hmaxframe.tif";
	open(frame);
	imID = getImageID();
	run("Scale Bar...", "width=10 height=2 font=12 color=White background=Black location=[Upper Right] bold");
	saveAs("PNG",d1+File.separator+codename+"rw_combinedRGB_Hmaxframe.tif.png");
	selectImage(imID);
	close();


	run("Set Scale...", "known=1 pixel=1 unit=µm");
	selectImage(gID);
	close();

	setBatchMode(false);
	
}