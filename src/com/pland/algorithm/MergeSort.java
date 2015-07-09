package com.pland.algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * http://exceptional-code.blogspot.ca/2011/07/external-sorting-for-sorting-large.html
 *
 * Cracking the coding interview
 * Page 118 for merge sort and page 120 for binary search
 */

public class MergeSort {
	
	public void read(String path, int size){

		try {
			
			FileInputStream fi = new FileInputStream(path);
			BufferedInputStream bi = new BufferedInputStream(fi);
			
			RandomAccessFile raf = new RandomAccessFile(path, "r");
			String temp = null;
			Integer[] integerArray = null;
			boolean flagOfCreateNewArray = true;
			int arrayPosition = 0;
			int fileNumber = 1;
			
			//Generate chunks of sorted data
			while( (temp = raf.readLine()) != null){
				if(flagOfCreateNewArray){
					integerArray = new Integer[size];
					arrayPosition = 0;
					flagOfCreateNewArray = false;
				}
				integerArray[arrayPosition] =  Integer.valueOf(temp);
				arrayPosition++;
				
				if(arrayPosition == size){
					flagOfCreateNewArray = true;
					QuickSort.sort(integerArray);
					FileWriter fw = new FileWriter(path+"TempOut"+String.valueOf(fileNumber));
					for(int tempOut : integerArray){
						fw.write(String.valueOf(tempOut));
						fw.write("\r\n");//For windows system only
					}
					fw.close();
					fileNumber++;
					
				}
				
			}
			raf.close();
			
			//Sort again from chunk data and write the smallest number into a big file each time
			fileNumber--;
			
			RandomAccessFile[] rafArray = new RandomAccessFile[fileNumber];
			for(int i = 0; i < fileNumber; i++){
				rafArray[i] = new RandomAccessFile(path+"TempOut"+String.valueOf(i+1), "r");
			}
			
			FileWriter sortedFile = new FileWriter(path+"Final");
			
			String[] chunkString = new String[fileNumber];
			Integer[] chunkInteger = new Integer[fileNumber];
			Boolean[] chunkEmptyFlag = new Boolean[fileNumber];
			
			//Initializing array
			for(int i = 0; i< fileNumber; i++){
				chunkEmptyFlag[i] = new Boolean(false);
			}
			
			//Tested that empty line at the end of file, will not be read by readLine command
			for(int i = 0; i < fileNumber; i++){
				if((chunkString[i] = rafArray[i].readLine()) != null){
					chunkInteger[i] = Integer.valueOf(chunkString[i]);
				}
				
			}
			
			boolean loopFlag = true;
			Integer smallestNum = null;
			Integer whichChunkFile = null;
			
			while(loopFlag){
				for(int j=0; j < fileNumber; j++){
					if(chunkInteger[j] != null){
						if(smallestNum == null){
							smallestNum = chunkInteger[j];
							whichChunkFile = new Integer(j);
						}
						else{
							if(smallestNum-chunkInteger[j]>0){
								smallestNum = chunkInteger[j];
								whichChunkFile = new Integer(j);

							}
						}
					}
				}
				


				
				
				//Read next data from one chunk file or set flag to that chunk file as reaching the end
				if(whichChunkFile != null){
					//Insert into the final file
					sortedFile.write(String.valueOf(smallestNum));
					System.out.println(String.valueOf(smallestNum));
					smallestNum = null; //Reset value for next loop
					
					if((chunkString[whichChunkFile.intValue()] = rafArray[whichChunkFile.intValue()].readLine()) != null){
						chunkInteger[whichChunkFile.intValue()] = Integer.valueOf(chunkString[whichChunkFile.intValue()]);
					}
					else{
						chunkEmptyFlag[whichChunkFile.intValue()] = new Boolean(true);
						chunkInteger[whichChunkFile.intValue()] = null;
					}
				}
				
				boolean breakFlag = false;
				for(int i = 0; i<fileNumber; i++){
					if(chunkEmptyFlag[i].equals(new Boolean(false))){
						breakFlag = true;
						break;
					}
				}
				if(!breakFlag){
					loopFlag = false;
					for(int i = 0; i < fileNumber; i++){
						rafArray[i].close();
					}
				}
			}
			
			sortedFile.close();
			
			

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeSortedToFiles(){
		
	}
	
//	public static void main(String args[]){
//		
//	}

}
