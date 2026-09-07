
import '../styles/home.css';

import Feed from '../components/Feed.jsx';
import Sidebar from '../components/Sidebar.jsx';
import Rightbar from '../components/Rightbar.jsx';
import Login from '../components/Login.jsx';

import { useAuth } from '../context/AuthContext.jsx';


function Home() {

    const { isAuthenticated, loading } = useAuth();


    // Todavía estamos comprobando si existe una sesión
    if (loading) {
        return <p>Cargando...</p>;
    }


    // Ya hemos comprobado la sesión y no hay usuario
    if (!isAuthenticated) {
        return <Login />;
    }


    // Usuario autenticado
    return (
        <div className="container">

            <aside className="sidebar">
                <Sidebar />
            </aside>

            <main className="feed">
                <Feed />
            </main>

            <aside className="rightbar">
                <Rightbar />
            </aside>

        </div>
    );
}


export default Home;
