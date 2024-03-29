#include "SettingScene.h"

USING_NS_CC;
using namespace CocosDenshion;

Scene* Setting::createScene()
{
	// 'scene' is an autorelease object
	auto scene = Scene::create();

	// 'layer' is an autorelease object
	auto layer = Setting::create();

	// add layer as a child to scene
	scene->addChild(layer);

	// return the scene
	return scene;
}

// on "init" you need to initialize your instance
bool Setting::init()
{
	//////////////////////////////
	// 1. super init first
	if ( !Layer::init() )
	{
		return false;
	}

	log("Setting init");

	Size visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();

	Sprite *bg = Sprite::create("setting-back.png");

	// position the label on the center of the screen
	bg->setPosition(Vec2(origin.x + visibleSize.width/2,
		origin.y + visibleSize.height /2));
	this->addChild(bg);

	//音效
	auto soundOnMenuItem = MenuItemImage::create(
		"on.png",
		"on.png");
	auto soundOffMenuItem = MenuItemImage::create(
		"off.png",
		"off.png");

	auto soundToggleMenuItem = MenuItemToggle::createWithCallback(CC_CALLBACK_1(Setting::menuSoundToggleCallback, this), 
		soundOnMenuItem, 
		soundOffMenuItem,
		
		NULL);
	soundToggleMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(818, 220)));

	//音乐
	auto musicOnMenuItem  = MenuItemImage::create(
		"on.png",
		"on.png");
	auto musicOffMenuItem  = MenuItemImage::create(
		"off.png",
		"off.png");
	auto musicToggleMenuItem = MenuItemToggle::createWithCallback(CC_CALLBACK_1(Setting::menuMusicToggleCallback, this),
		musicOnMenuItem,
		musicOffMenuItem,
		NULL );
	musicToggleMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(818, 362)));

	//Ok按钮
	auto okMenuItem  = MenuItemImage::create( 
		"ok-down.png",
		"ok-up.png",
		CC_CALLBACK_1(Setting::menuOkCallback, this));

	okMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(600, 510)));

	Menu* mn = Menu::create(soundToggleMenuItem, musicToggleMenuItem,okMenuItem, NULL);
	mn->setPosition(Vec2::ZERO);
	this->addChild(mn);

	UserDefault*DF=UserDefault::getInstance();
	if(DF->getBoolForKey(SOUND_KEY)){
		soundToggleMenuItem->setSelectedIndex(0);
	}
	else{
		soundToggleMenuItem->setSelectedIndex(1);

	}
	if(DF->getBoolForKey(MUSIC_KEY)){
		musicToggleMenuItem->setSelectedIndex(0);
	}
	else{
		musicToggleMenuItem->setSelectedIndex(1);

	}
	return true;
}

void Setting::menuOkCallback(Ref* pSender)
{
	Director::getInstance()->popScene();
	UserDefault *DF=UserDefault::getInstance();

	if (DF->getBoolForKey(SOUND_KEY)) {
		SimpleAudioEngine::getInstance()->playEffect("sound/Blip.wav");
	}
}

void Setting::menuSoundToggleCallback(Ref* pSender)
{
	auto soundToggleMenuItem = (MenuItemToggle*)pSender;
	log("soundToggleMenuItem %d", soundToggleMenuItem->getSelectedIndex());

	UserDefault *DF=UserDefault::getInstance();
	if (DF->getBoolForKey(SOUND_KEY)) {
		SimpleAudioEngine::getInstance()->playEffect("sound/Blip.wav");
	}

	if (DF->getBoolForKey(SOUND_KEY)) {//选中状态Off -> On,此时不播放
		//isEffect = false;
		DF->setBoolForKey(SOUND_KEY,false);
	} else {
		//isEffect = true;
		DF->setBoolForKey(SOUND_KEY,true);
		SimpleAudioEngine::getInstance()->playEffect("sound/Blip.wav");
	}
}


void Setting::menuMusicToggleCallback(Ref* pSender)
{
	auto musicToggleMenuItem = (MenuItemToggle*)pSender;
	log("musicToggleMenuItem %d", musicToggleMenuItem->getSelectedIndex());

	UserDefault *DF=UserDefault::getInstance();
	if (DF->getBoolForKey(MUSIC_KEY)) {//选中状态Off -> On
		SimpleAudioEngine::getInstance()->stopBackgroundMusic("sound/Synth.mp3");
		DF->setBoolForKey(MUSIC_KEY,false);
	} else {
		SimpleAudioEngine::getInstance()->playBackgroundMusic("sound/Synth.mp3");
		DF->setBoolForKey(MUSIC_KEY,true);
	}
	if (DF->getBoolForKey(SOUND_KEY)) {
		SimpleAudioEngine::getInstance()->playEffect("sound/Blip.wav");
	}
}


void Setting::onEnter()
{
	Layer::onEnter();
	log("Setting onEnter");
}

void Setting::onEnterTransitionDidFinish()
{
	Layer::onEnterTransitionDidFinish();
	log("Setting onEnterTransitionDidFinish");	
	//isEffect = true;
	//播放
	UserDefault *DF=UserDefault::getInstance();

	if (DF->getBoolForKey(MUSIC_KEY)) {
		SimpleAudioEngine::getInstance()->playBackgroundMusic("sound/Synth.mp3", true);
	}
}

void Setting::onExit()
{
	Layer::onExit();
	log("Setting onExit");	
}

void Setting::onExitTransitionDidStart()
{
	Layer::onExitTransitionDidStart();
	log("Setting onExitTransitionDidStart");
}

void Setting::cleanup()
{
	Layer::cleanup();
	log("Setting cleanup");	
	//停止
	SimpleAudioEngine::getInstance()->stopBackgroundMusic("sound/Synth.mp3");
}