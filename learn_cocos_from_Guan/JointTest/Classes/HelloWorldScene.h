#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"

#define Tag 100
class HelloWorld : public cocos2d::Layer
{
	cocos2d::EventListenerPhysicsContact*listener;
public:

    // there's no 'id' in cpp, so we recommend returning the class instance pointer
    static cocos2d::Scene* createScene();

    // Here's a difference. Method 'init' in cocos2d-x returns bool, instead of returning 'id' in cocos2d-iphone
    virtual bool init();  

	virtual bool onTouchBegan(cocos2d::Touch *touch, cocos2d::Event *unused_event);
    
	void addNewSpriteAtPos(cocos2d::Vec2 pos);
    // implement the "static create()" method manually
    CREATE_FUNC(HelloWorld);


};

#endif // __HELLOWORLD_SCENE_H__
