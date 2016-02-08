package views;

import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.*;

public class StatsProgressBarUI extends BasicProgressBarUI {
	
	@Override
	protected void paintDeterminate(Graphics g, JComponent c) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int iStrokWidth = 3;
		g2d.setStroke(new BasicStroke(iStrokWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(progressBar.getForeground());
		g2d.setBackground(progressBar.getBackground());
		
		int width = progressBar.getWidth();
		int height = progressBar.getHeight();
		
		RoundRectangle2D outline = new RoundRectangle2D.Double((iStrokWidth / 2), (iStrokWidth / 2),
				width - iStrokWidth, height - iStrokWidth,
				height, height);

		g2d.draw(outline);
		
		int iInnerHeight = height - (iStrokWidth * 4);
		int iInnerWidth = width - (iStrokWidth * 4);
		
		double dProgress = progressBar.getPercentComplete();
		if (dProgress < 0) {
			dProgress = 0;
		} else if (dProgress > 1) {
			dProgress = 1;
		}
		
		iInnerWidth = (int) Math.round(iInnerWidth * dProgress);
		
		int x = iStrokWidth * 2;
		int y = iStrokWidth * 2;
		
		Point2D start = new Point2D.Double(x, y);
		Point2D end = new Point2D.Double(x, y + iInnerHeight);
		
		RoundRectangle2D fill = new RoundRectangle2D.Double(iStrokWidth * 2, iStrokWidth * 2,
				iInnerWidth, iInnerHeight, iInnerHeight, iInnerHeight);
		
		g2d.fill(fill);
		
		g2d.setFont(progressBar.getFont());
		//g2d.setColor(progressBar.getBackground());
		//g2d.setXORMode(progressBar.getForeground());
		g2d.setColor(Color.WHITE);
		FontMetrics fm = g2d.getFontMetrics(progressBar.getFont());
		String string = progressBar.getString();
		int stringHeight = fm.getHeight();
		int stringWidth = fm.stringWidth(string);
		g2d.drawString(string, 
				(c.getWidth() - stringWidth) >>> 1, 
				((c.getHeight() + stringHeight) >>> 1) - fm.getDescent());
		
		
		g2d.dispose();
	}
	
	@Override
	protected void paintIndeterminate(Graphics g, JComponent c) {
		super.paintIndeterminate(g, c); //To change body of generated methods, choose Tools | Templates.
	}
	
}