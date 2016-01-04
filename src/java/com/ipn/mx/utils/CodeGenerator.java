package com.ipn.mx.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CodeGenerator {
	
	public static byte[] generateQR( String code, String fileType ){
		ByteArrayOutputStream arrayOS = null;
		int size = 125;
		Hashtable<EncodeHintType, ErrorCorrectionLevel> table =
				new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		table.put( EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L );
		byte [] buffer = null;
		
		QRCodeWriter qrWriter = new QRCodeWriter( );
		try {
			BitMatrix bitMatrix = qrWriter.encode( code, BarcodeFormat.QR_CODE, size, size, table );
			int codeWidth = bitMatrix.getWidth( );
			BufferedImage image = new BufferedImage( codeWidth, codeWidth, BufferedImage.TYPE_INT_RGB );
			image.createGraphics( );
			
			Graphics2D graphics = (Graphics2D)image.getGraphics( );
			graphics.setColor( Color.WHITE );
			graphics.fillRect(  0, 0, codeWidth, codeWidth );
			graphics.setColor( Color.BLACK );
			
			for( int i = 0; i < codeWidth; i++ ){
				for( int j = 0; j < codeWidth; j++ ){
					if( bitMatrix.get( i, j ) ){
						graphics.fillRect( i, j, 1, 1 );
					}
				}
			}
			arrayOS = new ByteArrayOutputStream( );
			ImageIO.write( image, fileType, arrayOS );
			arrayOS.flush( );
			buffer = arrayOS.toByteArray( );
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( arrayOS != null ){
				try {
					arrayOS.close( );
				} catch (IOException e) {
					e.printStackTrace();
				}//end try-catch
			}//end if arrayOS != null
		}//end try-catch
		return buffer;
	}//end method
	
	public static String generateSHA( String code ){
		return DigestUtils.sha1Hex( code );
	}
}
