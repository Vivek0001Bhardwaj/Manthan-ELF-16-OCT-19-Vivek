package com.manthan.resumefinder.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class ResumeDaoImpl implements ResumeDao {

	StringTokenizer sf = null;
	String fExt = null;
	List<File> at = null;

	/*public void perform2(File fl,String searchText,StringTokenizer st)
	{
		boolean flag = false;

		if(fl.isFile())
		{
			fExt =  FilenameUtils.getExtension(fl.getName());

			if(fExt.equalsIgnoreCase("pdf"))
			{
				String text = pdfToTextConvertor(fl);

				if(searchText.length()==1)
				{
					flag = pdfSearchSingle(searchText,text);
				}
				if(st!=null)
				{
					flag = pdfSearchMul(searchText,text);
				}
				else
				{
					flag = pdfSearchSingle(searchText,text);
				}
			}
			else if(fExt.equalsIgnoreCase("docx"))
			{
				String getDocx= docxToTextConvertor(fl);

				if(st!=null)
				{
					flag = docxSearchMul(getDocx, searchText);
				}
				else
				{
					flag = docxSearchSingle(getDocx,searchText);
				}
			}
		}
		if(flag)
			at.add(fl);

	}*/ //End of perform2 method

	public String pdfToTextConvertor(File file)
	{
		String text = null;
		try
		{
			PDDocument document = PDDocument.load(file);

			//Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper1 = new PDFTextStripper();

			//Retrieving text from PDF document
			text = pdfStripper1.getText(document);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return text;

	}//End of pdfToTextConvertor function

	public String docxToTextConvertor(File file)
	{
		String getDocx = null;
		try
		{
			FileInputStream fis =new FileInputStream(file.getAbsolutePath());

			XWPFDocument docx= new XWPFDocument(OPCPackage.open(fis));

			XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
			getDocx = extractor.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getDocx;

	}//End of docxToTextConvertor function

	public boolean docxSearchMul(String docxText,String searchText)
	{
		boolean flag = false;

		if(pdfSearchMul(searchText,docxText))
		{
			flag = true;
		}

		return flag;

	}//End of docxSearchMul function

	public boolean docxSearchSingle(String docxText,String searchText)
	{
		boolean flag = false;

		if(pdfSearchSingle(searchText,docxText))
		{	
			flag = true;
		}

		return flag;

	}//End of docxSearchSingle function

	public boolean pdfSearchMul(String searchText,String text)
	{
		boolean flag = false;

		sf = new StringTokenizer(text,":-,");

		String input[] = searchText.split("\t|,");

		int count=0;

		String lines[] = text.split("\\n");

		for(String line : lines)
		{
			for(String word : input)
			{
				if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(line,word))
				{
					++count;
				}
				if(count==input.length)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}

		return flag;

	}//End of pdfSearchMul function

	public boolean pdfSearchSingle(String searchText,String text)
	{
		boolean flag = false;

		if(searchText.length()==1)
		{
			sf = new StringTokenizer(text,":-,/");

			while (sf.hasMoreTokens())
			{  
				String word = sf.nextToken();
				word = word.trim();
				if(word.equals(searchText))
				{
					flag = true;
					break;
				}
			}
		}
		else if(searchText.contains("@"))
		{
			sf = new StringTokenizer(text);

			while (sf.hasMoreTokens())
			{  
				String word = sf.nextToken();
				if(word.contains("@") && word.equalsIgnoreCase(searchText))
				{
					flag = true;
					break;
				}
			}
		} 
		else if(searchText.contains("+") && searchText.length()>=10)
		{
			if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(text,searchText))
			{
				flag = true;
			}
		}
		else
		{
			if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(text,searchText))
			{
				flag = true;
			}
		}
		return flag;

	}//End of pdfSearchSingle function

	public List<File> perform(String filePath,String searchText)
	{
		at=new ArrayList<File>();
		List<File> af= new ArrayList<File>();

		StringTokenizer st = null;

		boolean flag = false;

		if(searchText.contains(","))
		{
			st = new StringTokenizer(searchText,",");
		}

		try
		{
			// Getting all documents in array of type File
			File[] fls = new File(filePath).listFiles();

			//2nd way to search by using Parallel Stream forEach method
			/*af = Arrays.asList(fls);
			final StringTokenizer sf = st;

			af.parallelStream().forEach(f1 -> perform2(f1,searchText,sf));*/

			//1st way to search by using simple For-Loop
			for(File fl : fls)
			{
				if(fl.isFile())
				{
					fExt =  FilenameUtils.getExtension(fl.getName());

					if(fExt.equalsIgnoreCase("pdf"))
					{
						String text = pdfToTextConvertor(fl);

						if(searchText.length()==1)
						{
							flag = pdfSearchSingle(searchText,text);
						}
						if(st!=null)
						{
							flag = pdfSearchMul(searchText,text);
						}
						else
						{
							flag = pdfSearchSingle(searchText,text);
						}
					}
					else if(fExt.equalsIgnoreCase("docx"))
					{
						String getDocx= docxToTextConvertor(fl);

						if(st!=null)
						{
							flag = docxSearchMul(getDocx, searchText);
						}
						else
						{
							flag = docxSearchSingle(getDocx,searchText);
						}
					}
				}
				if(flag)
				{
					af.add(fl);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return af;
		//return at;

	}//End of perform function

	@Override
	public String getName(String mailId)
	{
		String name = null;

		if(mailId!=null)
		{
			int index = mailId.indexOf('@');

			name = mailId.substring(0,index);

			if(name.contains("."))
			{
				int dotIndex = name.indexOf('.');

				String firstName = name.substring(0,dotIndex);
				String lastName = name.substring(dotIndex+1);

				name = firstName+" "+lastName;
			}
		}
		return name;

	}//End of getName function

	@Override
	public String getMail(File file)
	{
		String mailId = null;

		fExt =  FilenameUtils.getExtension(file.getName());

		if(fExt.equalsIgnoreCase("pdf"))
		{
			String text = pdfToTextConvertor(file);

			sf = new StringTokenizer(text);

			while (sf.hasMoreTokens())
			{  
				String word = sf.nextToken();
				if(word.contains("@"))
				{
					mailId = word;
					break;
				}
			}
		}
		else if(fExt.equalsIgnoreCase("docx"))
		{
			String getDocx= docxToTextConvertor(file);

			String getDocxSplit[] = getDocx.split("\\n|\\r");

			for(String line : getDocxSplit)
			{
				String wordByword[] = line.split("\\s");
				for(String word : wordByword)
				{
					word = word.trim();
					if(word.contains("@"))
					{
						if(word.contains(".com"))
						{
							int index = word.indexOf(".com");
							word = word.substring(0,index+4);
							mailId = word;
							break;
						}
						else if(word.contains(".org"))
						{
							int index = word.indexOf(".org");
							word = word.substring(0,index+4);
							mailId = word;
							break;
						}
					}
				}
			}
		}
		return mailId;

	}//End of getMail function

}//End of ResumeDaoImpl class
