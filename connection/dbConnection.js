const { I } = inject();


class Dbs
{
     connect(conf) {
        const {
            user='katalonteam',
            password='team@123',
            host='192.168.5.221',
            port='3306',
            name='katalon_repo',
        } = conf.database;
        const connectionName = `${name}-${Math.random().toString(36).substring(2, 15)}`;
        console.log('pre connect');
        console.log(`name ${connectionName}`);
        console.log(`mysql://${user}:${password}@${host}:${port}/${name}`);
         I.connect(
            connectionName,
            `mysql://${user}:${password}@${host}:${port}/${name}`,
        );
        console.log('post connect');
        return connectionName;
    }

     disconnect(name) {
        console.log(`pre disconnect ${name}`);
         I.removeConnection(name);
        console.log(`post disconnect ${name}`);
    }

     query(args) {
        const conf =  configUtil.get();
        const connectionName =  this.connect(conf);
        const result =  I.query(connectionName, ...args);
         this.disconnect(connectionName);
        return result;
    }

     queryDatabase(conf, args) {
        const connectionName =  this.connect(conf);
        const result =  I.query(connectionName, ...args);
         this.disconnect(connectionName);
        return result;
    }

     run(args) {
        const conf =  configUtil.get();
        const connectionName =  this.connect(conf);
        const result =  I.run(connectionName, ...args);
         this.disconnect(connectionName);
        return result;
    }
}


module.exports = new Dbs;