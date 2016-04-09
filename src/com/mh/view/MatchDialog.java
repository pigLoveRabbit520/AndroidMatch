package com.mh.view;


import android.view.View;
import android.view.View.*;
import com.mh.match.*;
import android.app.Dialog;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.TextView;

public class MatchDialog extends Dialog implements OnClickListener {
	
	private GameView gameView;
	private MainActivity activity;

	public MatchDialog(Context context, GameView gameView, String msg, int time) {
		// TODO 自动生成的构造函数存根
		super(context, R.style.match_dialog);
		this.gameView = gameView;
		this.activity = (MainActivity)context;
		this.setContentView(R.layout.match_dialog);
		TextView txtTitle = (TextView) findViewById(R.id.tv_dialog_title);
		TextView txtUsedTime = (TextView) findViewById(R.id.tv_dialog_usedTime);
		ImageButton btnExit = (ImageButton) findViewById(R.id.btn_dialog_exit);
		ImageButton btnNext = (ImageButton) findViewById(R.id.btn_dialog_next);
		ImageButton btnReplay = (ImageButton) findViewById(R.id.btn_dialog_replay);
		
		txtTitle.setText(msg);
		txtUsedTime.setText(txtUsedTime.getText().toString().replace("$", String.valueOf(time)));
		btnExit.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		btnReplay.setOnClickListener(this);
		this.setCancelable(false);
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.btn_dialog_exit:
			activity.exit();
			break;
		case R.id.btn_dialog_next:
			gameView.next();
			activity.setTotalNum();
			break;
		case R.id.btn_dialog_replay:
			gameView.replay();
			activity.setTotalNum();
			break;
		}
		
		this.cancel();
	}
	
	
	

}
