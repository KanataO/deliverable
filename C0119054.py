import pygame
import sys
import time
from pygame import Color
import math

class Ball(pygame.sprite.Sprite):
    def __init__(self, group, screen, color, x, y, r, vx, vy):
        super().__init__(group)
        self.r = r
        self.color = color
        self.vx = vx
        self.vy = vy
        self.screen = screen
        self.image = pygame.Surface((r, r))
        self.image.fill(color)
        self.rect = pygame.Rect(x, y, r, r)


    def update(self):
        self.rect.move_ip(self.vx, self.vy)
        if self.rect.x <= 0:
            self.vx = -self.vx
        if self.rect.x >= 400:
            self.vx = -self.vx
        if self.rect.y <= 0:
            self.vy = -self.vy
        if self.rect.y >= 600:
            self.vy = -self.vy

class Bullet(Ball):
    def __init__(self, group, screen, x, y, vx, vy):
        d = 5
        super().__init__(group, screen, Color("orange"), x, y, d, vx, vy)

class Battery(pygame.sprite.Sprite):
    def __init__(self, screen):
        super().__init__()
        self.screen = screen
        self.image = pygame.Surface((30, 15))
        self.image.fill(Color("green"))
        self.rect = pygame.Rect(185, 92, 30, 15)

    def draw(self):
        self.screen.blit(self.image, self.rect)

class Chara(pygame.sprite.Sprite):
    def __init__(self, screen, x, y):
        super().__init__()
        self.rect = pygame.Rect(x, y, 6, 6)
        self.image = pygame.Surface((6, 6))
        self.image.fill(Color("blue"))
        self.x = x
        self.y = y
        self.dx = 0
        self.dy = 0
        self.vx = 3
        self.vy = 3
        self.ad = 1
        self.ws = 1
        self.screen = screen

    def draw(self):
        self.screen.blit(self.image, self.rect)

    def update(self):
        self.rect.move_ip(self.dx, self.dy)
        self.dx = 0
        self.dy = 0

    def up(self):
        self.dy -= self.vy
        # if (self.y >= 0):
        #     self.y = y     # 移動量の設定は、独自メソッド
    
    def down(self):
        self.dy += self.vy

    def left(self):
        self.dx -= self.vx
        # if (x >= 0):
        #     self.x = x     # 移動量の設定は、独自メソッド
    
    def right(self):
        self.dx += self.vx

    def w(self):
        self.dy -= self.ws
        # if (self.y >= 0):
        #     self.y = y     # 移動量の設定は、独自メソッド
    
    def s(self):
        self.dy += self.ws

    def a(self):
        self.dx -= self.ad
        # if (x >= 0):
        #     self.x = x     # 移動量の設定は、独自メソッド
    
    def d(self):
        self.dx += self.ad

class Graze(pygame.sprite.Sprite):
    def __init__(self, screen, x, y):
        super().__init__()
        self.rect = pygame.Rect(x, y, 16, 16)
        self.image = pygame.Surface((16, 16))
        self.image.fill(Color("yellow"))
        self.x = x
        self.y = y
        self.dx = 0
        self.dy = 0
        self.vx = 3
        self.vy = 3
        self.ad = 1
        self.ws = 1
        self.screen = screen

    def draw(self):
        self.screen.blit(self.image, self.rect)

    def update(self):
        self.rect.move_ip(self.dx, self.dy)
        self.dx = 0
        self.dy = 0

    def up(self):
        self.dy -= self.vy
        # if (self.y >= 0):
        #     self.y = y     # 移動量の設定は、独自メソッド
    
    def down(self):
        self.dy += self.vy

    def left(self):
        self.dx -= self.vx
        # if (x >= 0):
        #     self.x = x     # 移動量の設定は、独自メソッド
    
    def right(self):
        self.dx += self.vx

    def w(self):
        self.dy -= self.ws
        # if (self.y >= 0):
        #     self.y = y     # 移動量の設定は、独自メソッド
    
    def s(self):
        self.dy += self.ws

    def a(self):
        self.dx -= self.ad
        # if (x >= 0):
        #     self.x = x     # 移動量の設定は、独自メソッド
    
    def d(self):
        self.dx += self.ad

class Box:
    def __init__(self, w, h):
        pygame.init()
        self.width = w
        self.height = h
        self.bullets = pygame.sprite.Group()
        self.score = 0
        self.font = pygame.font.SysFont('nirmalauisemilight', 24)

    def set(self):
        screen = pygame.display.set_mode((400, 600))
        self.screen = screen
        self.clock = pygame.time.Clock()
        self.chara = Chara(screen, 197, 497)
        self.graze = Graze(screen, 192, 492)
        self.battery = Battery(screen)

    

    def fire1(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, -(3*2/math.sqrt(3)), 3/math.sqrt(3))
    
    def fire2(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, -(3/math.sqrt(3)), 3*2/math.sqrt(3))

    def fire3(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 0, 3)

    def fire4(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 3/math.sqrt(3), 3*2/math.sqrt(3))

    def fire5(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 3*2/math.sqrt(3), 3/math.sqrt(3))
    
    def fire6(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, -(5*2/math.sqrt(3)), 5/math.sqrt(3))
    
    def fire7(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, -(5/math.sqrt(3)), 5*2/math.sqrt(3))

    def fire8(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 0, 5)

    def fire9(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 5/math.sqrt(3), 5*2/math.sqrt(3))

    def fire0(self):
        Bullet(self.bullets, self.screen, self.battery.rect.x+15, self.battery.rect.y+15, 5*2/math.sqrt(3), 5/math.sqrt(3))

    def firer(self):
        pygame.sprite.Group.empty(self.bullets)

    def show_score(self):
        text = self.font.render( ("SCORE : %d" % self.score), True, (255, 255, 255))
        self.screen.blit(text, (0, 0))

    def animate(self):
        LOOP = True
        while LOOP:
            for event in pygame.event.get():
                # 「閉じる」ボタンを処理する
                if event.type == pygame.QUIT: LOOP = False

            self.clock.tick(60)      # 毎秒の呼び出し回数に合わせて遅延
            pressed_keys = pygame.key.get_pressed() # キー情報を取得
            if pressed_keys[pygame.K_UP]:    # 上が押されたら
                self.chara.up()
                self.graze.up()
            if pressed_keys[pygame.K_DOWN]:  # 下が押されたら
                self.chara.down()
                self.graze.down()
            if pressed_keys[pygame.K_LEFT]:    # 左が押されたら
                self.chara.left()
                self.graze.left()
            if pressed_keys[pygame.K_RIGHT]:  # 右が押されたら
                self.chara.right()
                self.graze.right()
            if pressed_keys[pygame.K_w]:    # 上が押されたら
                self.chara.w()
                self.graze.w()
            if pressed_keys[pygame.K_s]:  # 下が押されたら
                self.chara.s()
                self.graze.s()
            if pressed_keys[pygame.K_a]:    # 左が押されたら
                self.chara.a()
                self.graze.a()
            if pressed_keys[pygame.K_d]:  # 右が押されたら
                self.chara.d()
                self.graze.d()

            if pressed_keys[pygame.K_1]:
                self.fire1()
            if pressed_keys[pygame.K_2]:
                self.fire2()
            if pressed_keys[pygame.K_3]:
                self.fire3()
            if pressed_keys[pygame.K_4]:
                self.fire4()
            if pressed_keys[pygame.K_5]:
                self.fire5()
            if pressed_keys[pygame.K_6]:
                self.fire6()
            if pressed_keys[pygame.K_7]:
                self.fire7()
            if pressed_keys[pygame.K_8]:
                self.fire8()
            if pressed_keys[pygame.K_9]:
                self.fire9()
            if pressed_keys[pygame.K_0]:
                self.fire0()
            if pressed_keys[pygame.K_c]:
                self.firer()

            self.bullets.update()
            self.graze.update()
            self.chara.update()
            self.graze.draw()
            self.chara.draw()
            self.battery.draw()
            if pygame.sprite.spritecollideany(self.graze, self.bullets):
                self.score += 1
            if pygame.sprite.spritecollideany(self.chara, self.bullets):
                LOOP = False
            self.bullets.draw(self.screen)
            self.show_score()
            pygame.display.flip()
            self.screen.fill((0, 0, 0))

box = Box(300,300)
box.set()
box.animate()
pygame.quit()