import '../styles/home.css'
import Feed from '../components//Feed.jsx'
import Sidebar from '../components//Sidebar.jsx'
import Rightbar from '../components//Rightbar.jsx'

function Home(){

    return (
        <> 
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
        </>
    )
}

export default Home