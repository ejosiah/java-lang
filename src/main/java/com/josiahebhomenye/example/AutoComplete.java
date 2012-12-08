package com.josiahebhomenye.example;

import javax.swing.*;
import com.josiahebhomenye.algorithm.datastructure.TernarySearchTree;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class AutoComplete extends JFrame implements KeyListener {
	JTextField field;
	JTextArea textArea;
	private final TernarySearchTree tree = new TernarySearchTree();
	private final URL url;
	
	public AutoComplete() throws MalformedURLException{
		url = new URL("http://josiahebhomenye.com/words");
	}
	
	public void initialise() throws Exception{
		setLayout(new BorderLayout());
		loadWords();
		buildUI();
	}
	
	private void loadWords() throws IOException{
		Scanner scanner = new Scanner(url.openStream());
		List<String> words = new ArrayList<String>();
		
		while(scanner.hasNextLine()){
			String word = scanner.nextLine();
			if(word.length() > 1){
				words.add(word.toLowerCase());
			}
		}
		Collections.shuffle(words);
		for(String word : words){
			tree.add(word);
		}
	}
	
	private void buildUI(){
		field = new JTextField();
		add(field, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		field.addKeyListener(this);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String...args) throws Exception{
		new AutoComplete().initialise();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		new Worker().execute();
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}
	
	private class Worker extends SwingWorker<List<CharSequence>, Object>{

		@Override
		protected List<CharSequence> doInBackground() throws Exception {
			String prefix = field.getText().toLowerCase();
			List<CharSequence> possibleWords = null;
			if(prefix.length() > 2){
				possibleWords = tree.prefixSearch(prefix);
			}
			return possibleWords;
		}
		
		@Override
		protected void done(){
			try{		
				textArea.setText("");
				for(CharSequence word : get()){
					textArea.append(word + "\n");
				}
			}catch (Exception e) {
				
			}
		}
		
	}
	
}