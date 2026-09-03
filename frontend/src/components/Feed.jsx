import Pio from '../components/Pio.jsx'

function Feed(){


const pios = [
    {
        nick: "Xetloz",
        user: "xetloz1001",
        time: "hace 10min",
        text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        comments: 3,
        repios: 10,
        likes: 60,
        views: "5 mil",
        profileIMG: "1.jpeg"
    },
    {
        nick: "Ana García",
        user: "anagarcia",
        time: "hace 25min",
        text: "Hoy he aprendido algo nuevo en React. Poco a poco todo empieza a tener sentido 🚀",
        comments: 12,
        repios: 4,
        likes: 87,
        views: "2,4 mil",
        profileIMG: "2.jpeg"
    },
    {
        nick: "CarlosDev",
        user: "carlos_dev",
        time: "hace 1h",
        text: "¿Soy el único que piensa que pasar horas buscando un bug y descubrir que era un punto y coma es parte del aprendizaje? 😂",
        comments: 28,
        repios: 16,
        likes: 143,
        views: "8,7 mil",
        profileIMG: "3.jpeg"
    },
    {
        nick: "María López",
        user: "maria_lopez",
        time: "hace 2h",
        text: "Un café, unos auriculares y una tarde tranquila programando. No necesito mucho más ☕💻",
        comments: 7,
        repios: 3,
        likes: 45,
        views: "1,2 mil",
        profileIMG: "4.jpeg"
    },
    {
        nick: "TechNews",
        user: "technews",
        time: "hace 3h",
        text: "La tecnología avanza a una velocidad increíble. Cada año aparecen nuevas herramientas que cambian la forma en la que desarrollamos aplicaciones.",
        comments: 56,
        repios: 102,
        likes: 421,
        views: "32 mil",
        profileIMG: "5.jpeg"
    },
    {
        nick: "David Martín",
        user: "davidmartin",
        time: "hace 5h",
        text: "Acabo de terminar mi primer proyecto completo con React. No es perfecto, pero estoy bastante orgulloso del resultado. 🎉",
        comments: 19,
        repios: 8,
        likes: 96,
        views: "4,8 mil",
        profileIMG: "6.jpeg"
    },
    {
        nick: "Laura",
        user: "lauradev",
        time: "ayer",
        text: "A veces la mejor solución a un problema complicado es simplemente parar, descansar y volver a intentarlo mañana.",
        comments: 34,
        repios: 21,
        likes: 210,
        views: "12 mil",
        profileIMG: "7.jpeg"
    },
    {
        nick: "Gaming España",
        user: "gaming_es",
        time: "ayer",
        text: "¿Cuál es vuestro videojuego favorito de todos los tiempos? 🎮",
        comments: 154,
        repios: 73,
        likes: 890,
        views: "45 mil",
        profileIMG: "8.jpeg"
    },

];
    


    return (
        <>
            {pios.map((pio) => (
                <Pio 
                    nick = {pio.nick}
                    user = {pio.user}
                    time = {pio.time}
                    text = {pio.text}
                    comments= {pio.comments}
                    repios= {pio.repios}
                    likes= {pio.likes}
                    views= {pio.views}
                    profileIMG= {pio.profileIMG}
                />
            ))}
        </>
    )
    
}

export default Feed