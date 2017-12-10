package com.amall.core.action.time;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.service.image.IAccessoryService;



@Component("goods_photo_mat")
public class AutoMatGoodsPhoto {
static {
	    
	    try{
	    	System.out.println("java.library.path："+System.getProperty("java.library.path"));
	    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    	//System.loadLibrary("Hello");
	    	//System.load("/opt/tomcat_amall_main/shared/lib/libopencv_java310.so");
	    	
        }catch(UnsatisfiedLinkError e){
        	//Exception不行？
        	System.out.println("e:"+e.toString());
        	System.out.println("加载opencv so文件失败啦"+new Date());
        }
	  
}	
	
	
	@Autowired
	private IAccessoryService accessoryService;
	
	

	 
	 
	 public void execute ( )
		{
			try
			{	
				/* 检查商品的图片是否MAT格式存储数据库 */
				checkNotMatGoods ();
				//测试例子
				//Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
				//Mat mat=Mat.zeros(3,4 , CvType.CV_8UC1);
				//System.load("/opt/jdk1_7_0_80/jre/lib/amd64/libopencv_java310.so");
				//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
				//System.out.println("再次加载opencv so文件成功啦"+new Date());
				//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
				//System.out.println("2再次加载opencv so文件成功啦"+new Date());
				//Mat mat = new Mat();
				//mat.elemSize();
				//System.out.println( "mat rows= " + mat.rows() );
			   // System.out.println( "mat = " + mat.dump() );
				//Hello hello=new Hello();
				//hello.mytest(6);
				//Test(6);
			}
			catch (Exception e)
			{
				System.out.print("MAT 错误啦"+new Date());

			}
		}
	 private void checkNotMatGoods ( )
		{//将图片转换为opencv格式的MAT，直方图
		 // System.out.println("Welcome to OpenCV " + Core.VERSION);
		 // MatOfDMatch matches = new MatOfDMatch();
		 
		  	AccessoryExample accessoryExample = new AccessoryExample ();
			accessoryExample.clear ();
			accessoryExample.createCriteria ().andIsmatEqualTo(false).andPathLike("%store%");
			accessoryExample.setOrderByClause("id asc limit 0,500");
			
			List<Accessory> accs=this.accessoryService.getObjectListWithBLOBs(accessoryExample);
			
			if(!accs.isEmpty () && accs.size()>0){
				String dir_pre=Globals.UPLOAD_ROOT_FILE_PATH;
				for (Accessory accessory : accs)
				{
					Long aid=accessory.getId();
					String path=accessory.getPath();
					String filename=accessory.getName();
					String whole_filename=dir_pre+path+File.separator+filename;
					String imageType=filename.substring(filename.lastIndexOf(".")+1);
					
					if(imageType.equals("gif")){
						 	accessory.setIsmat(true);
					        //accessory.setOpencvmat(null);
					        this.accessoryService.updateByObject(accessory);
					        continue;
					}
					
					BufferedImage img1=null;
					try {
						img1= ImageIO.read(new File(whole_filename));
						img1=img_resize(img1);//图片统统缩小到相同尺寸，要不有的很大有的很小，怎么比较
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("路径:"+whole_filename+"读取失败");
						
						 accessory.setIsmat(true);
					        //accessory.setOpencvmat(null);
					      this.accessoryService.updateByObject(accessory);
					      continue;
						
					}
					if(img1!=null){
						//不写注释，因为我也不太懂，githut抄的研究了好几天
						//http://www.opencv.org.cn/opencvdoc/2.3.2/html/doc/tutorials/imgproc/histograms/histogram_calculation/histogram_calculation.html
						//https://github.com/euginfrancis/Java-Image-Comparing-with-OpenCV
						//https://github.com/torcellite/imageComparator
						Mat mat1 = conv_Mat(img1);
						//Mat source = Imgcodecs.imread(whole_filename, Imgcodecs.CV_LOAD_IMAGE_COLOR);
						
						Mat hist1 = new Mat();
						MatOfFloat histRanges = new MatOfFloat (0f, 180f);
						MatOfInt histSize = new MatOfInt(180);
						
						MatOfInt channels = new MatOfInt(0);
						boolean accumulate = false;
				        Imgproc.calcHist(Arrays.asList(mat1), channels, new Mat(), hist1, histSize, histRanges, accumulate);
				        
				        Core.normalize(hist1, hist1, 0, hist1.rows(), Core.NORM_MINMAX, -1, new Mat());
				        hist1.convertTo(hist1, CvType.CV_32F);
				        
				        //Accessory acc1=this.accessoryService.getByKey(aid);
				        byte[] bytes= Mat2ImageBytes(hist1,imageType);
				        accessory.setIsmat(true);
				        accessory.setOpencvmat(bytes);
				        this.accessoryService.updateByObject(accessory);
				        
				        System.out.println("MAT处理文件："+whole_filename+"");
					}
					
				}
			}
		}
	 
	 private BufferedImage img_resize(BufferedImage img_temp){
			BufferedImage dimg = new BufferedImage(180,180,img_temp.getType());
			Graphics2D g = dimg.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(img_temp,0,0,179,179,0,0,img_temp.getWidth()
					,img_temp.getHeight(),null);
			g.dispose();
			return dimg;
	}
	 private Mat conv_Mat(BufferedImage img){
			byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
			Mat mat = new Mat(img.getHeight(),img.getWidth(),CvType.CV_8UC3);
			mat.put(0,0,data);
			
			Mat mat1 = new Mat(img.getHeight(),img.getWidth(),CvType.CV_8UC3);
			Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2HSV);
			
			return mat1;
		}
	 public BufferedImage toBufferedImage(Mat m) {
			int type = BufferedImage.TYPE_BYTE_GRAY;
			if (m.channels() > 1) {
				type = BufferedImage.TYPE_3BYTE_BGR;
			}
			int bufferSize = m.channels() * m.cols() * m.rows();
			byte[] b = new byte[bufferSize];
			m.get(0, 0, b); // get all the pixels
			BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
			final byte[] targetPixels = ((DataBufferByte) image.getRaster()
					.getDataBuffer()).getData();
			System.arraycopy(b, 0, targetPixels, 0, b.length);
			return image;

		}
	 public static byte[] imageToBytes(BufferedImage image, String encoding) throws IOException{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, encoding, baos);
			return baos.toByteArray();
		}
	 public static BufferedImage bytesToImage(byte[] buf) throws IOException{
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			return ImageIO.read(bais);
		}
	 public static Mat Image2Mat(BufferedImage image, String imageType) throws IOException{
			MatOfByte mob = new MatOfByte(imageToBytes(image, imageType) );
			return Imgcodecs.imdecode(mob, Imgcodecs.CV_LOAD_IMAGE_COLOR);
			//return Highgui.imdecode(mob, Highgui.CV_LOAD_IMAGE_COLOR);
		}
	 public static Mat bytes2Mat(byte[] bytes){
			MatOfByte mob = new MatOfByte( bytes );
			return Imgcodecs.imdecode(mob, Imgcodecs.CV_LOAD_IMAGE_COLOR);
			//return Highgui.imdecode(mob, Highgui.CV_LOAD_IMAGE_COLOR);
		}
	 public static byte[] Mat2ImageBytes(Mat mat, String imageType){//.png
			MatOfByte buffer = new MatOfByte();
			Imgcodecs.imencode("."+imageType, mat, buffer);
			//Highgui.imencode("."+imageType, mat, buffer);
			return buffer.toArray();
		}
	 
	 public static Mat image2Mat(File file) throws IOException {
			return image2Mat(file, CvType.CV_8UC3);
		}
		
		/**
		 * TODO: doc it
		 * 
		 * @param file
		 * @param type
		 * @return
		 * @throws IOException
		 */
		public static Mat image2Mat(File file, int type) throws IOException {
			BufferedImage image = ImageIO.read(file);

			byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer())
					.getData();

			Mat mat = new Mat(image.getHeight(), image.getWidth(), type);
			mat.put(0, 0, data);

			return mat;
		}
}
