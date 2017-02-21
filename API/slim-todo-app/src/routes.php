<?php
// Routes

$app->group('/api/v1', function () use ($app) {
    
  // get all event
  $app->get('/events',function ($request, $response, $args) {
        $sth = $this->db->prepare("SELECT e.id, e.title, e.user_id, e.date, e.hour, e.address, e.zipcode, e.city, e.comment, e.creationDate, u.firstname, u.lastname FROM event e INNER JOIN user u ON e.user_id=u.id ORDER BY creationDate");
      $sth->execute();
      $todos = $sth->fetchAll();
      var_dump ($todos);
      return $this->response->withJson($todos);
  });

  $app->get('/event/[{id}]', function ($request, $response, $args) {
         $sth = $this->db->prepare("SELECT e.id, e.title, e.user_id, e.date, e.hour, e.address, e.zipcode, e.city, e.comment, e.creationDate, u.firstname, u.lastname FROM event e INNER JOIN user u ON e.user_id = u.id WHERE e.id=:id");
        $sth->bindParam("id", $args['id']);
        $sth->execute();
        $todos = $sth->fetchObject();
        return $this->response->withJson($todos);
    });

     // Add a new event
    $app->post('/newevent', function ($request, $response) {
        $event = json_decode($request->getBody());
        $sql = "INSERT INTO event (title, user_id, hour, address, zipcode, city, comment, creationDate) VALUES (:title, :user_id, :hour, :address, :zipcode, :city, :comment, :creationDate)";
        $sth = $this->db->prepare($sql);
        $sth->bindParam("title", $event->title);
        $sth->bindParam("user_id", $event->user_id);
//        $sth->bindParam("date", $event->date);
        $sth->bindParam("hour", $event->hour);
        $sth->bindParam("address", $event->address);
        $sth->bindParam("zipcode", $event->zipcode);
        $sth->bindParam("city", $event->city);
        $sth->bindParam("comment", $event->comment);
        $sth->bindParam("creationDate", $event->creationDate);
        $sth->execute();
        $event->id = $this->db->lastInsertId();
        return $this->response->withJson($event)->withStatus(201);
    });

//    // DELETE a todo with given id
//    $app->delete('/event/[{id}]', function ($request, $response, $args) {
//        $sth = $this->db->prepare("DELETE FROM event WHERE id=:id");
//        $sth->bindParam("id", $args['id']);
//        $sth->execute();
//        return $this->response->withStatus(204); //no-content
//    });

// Update todo with given id
//    $app->put('/event/[{id}]', function ($request, $response, $args) {
//        $event = json_decode($request->getBody());
//        $sql = "UPDATE event SET task=:task,priority=:priority  WHERE id=:id";
//        $sth = $this->db->prepare($sql);
//        $sth->bindParam("id", $args['id']);
//        $sth->bindParam("task", $todo->task);
//        $sth->bindParam("priority", $todo->priority);
//        $sth->execute();
//        //load complete oci_fetch_object
//        $sth = $this->db->prepare("SELECT * FROM task WHERE id=:id");
//        $sth->bindParam("id", $args['id']);
//        $sth->execute();
//        $todo = $sth->fetchObject();
//        //$input['id'] = $args['id'];
//        return $this->response->withJson($todo);
//    });
});
