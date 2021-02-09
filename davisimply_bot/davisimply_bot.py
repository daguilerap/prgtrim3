import telebot
import requests
from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
from bs4 import BeautifulSoup
from secrets import username, password

bot = telebot.TeleBot("1617797831:AAHJoQk90g9e0p_uwU9VakJdCrHgilGd7B0")



@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
    bot.reply_to(message, "Inserta una url valida de un perfil de facebook. Ejemplo: profile.php?id=1071044420&sk=about")

@bot.message_handler(func=lambda message: True)
def echo_all(message):
    url=message.text
    try:
        prueba(url)
        doc = open('pdfreporte.pdf', 'rb')
        bot.send_document(message.chat.id, doc)
    except:
         bot.reply_to (message,"Error")
def prueba(url):
    payload = {
        'email': username,
        'pass': password
    }
    login_basic_url = 'https://mbasic.facebook.com/login'

    with requests.Session() as session:
        session.post(login_basic_url, data=payload)
        page = session.get('https://mbasic.facebook.com/'+url)

    soup = BeautifulSoup(page.content, "html.parser")
    name = soup.find('title').text
    photo = soup.find('img',class_='bo k').get('src')

    nombre_local_imagen = "prueba.jpg"
    imagen = requests.get(photo).content
    with open(nombre_local_imagen, 'wb') as handler:
        handler.write(imagen)

    w, h = A4
    c = canvas.Canvas("pdfreporte.pdf",pagesize=A4)
    c.drawString(50, h - 50, name)
    c.drawImage("prueba.jpg", 50, h - 300)
    c.save()

   # mandar()


bot.polling()







