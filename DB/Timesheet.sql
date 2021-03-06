PGDMP          :                z            FinalProject    14.2    14.2 8    3           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            4           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            5           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            6           1262    16394    FinalProject    DATABASE     k   CREATE DATABASE "FinalProject" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE "FinalProject";
                postgres    false            ?            1259    16416 	   Employees    TABLE     ?   CREATE TABLE public."Employees" (
    "Id" integer NOT NULL,
    "Name" text NOT NULL,
    "Rol" text NOT NULL,
    "Password" text NOT NULL
);
    DROP TABLE public."Employees";
       public         heap    postgres    false            ?            1259    16415    Employees_Id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Employees_Id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."Employees_Id_seq";
       public          postgres    false    210            7           0    0    Employees_Id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."Employees_Id_seq" OWNED BY public."Employees"."Id";
          public          postgres    false    209            ?            1259    16508    Manager    TABLE     h   CREATE TABLE public."Manager" (
    "Emplyee_Id" integer NOT NULL,
    "Manager_Id" integer NOT NULL
);
    DROP TABLE public."Manager";
       public         heap    postgres    false            ?            1259    16425 	   timesheet    TABLE     ?   CREATE TABLE public.timesheet (
    id_timesheet integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    id_manager integer,
    id_employee integer
);
    DROP TABLE public.timesheet;
       public         heap    postgres    false            ?            1259    16424    Timesheet_id_timesheet_seq    SEQUENCE     ?   CREATE SEQUENCE public."Timesheet_id_timesheet_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public."Timesheet_id_timesheet_seq";
       public          postgres    false    212            8           0    0    Timesheet_id_timesheet_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."Timesheet_id_timesheet_seq" OWNED BY public.timesheet.id_timesheet;
          public          postgres    false    211            ?            1259    16497    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16459    projects    TABLE     s   CREATE TABLE public.projects (
    id_project integer NOT NULL,
    name text,
    id_employee integer NOT NULL
);
    DROP TABLE public.projects;
       public         heap    postgres    false            ?            1259    16458    projects_id_project_seq    SEQUENCE     ?   CREATE SEQUENCE public.projects_id_project_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.projects_id_project_seq;
       public          postgres    false    217            9           0    0    projects_id_project_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.projects_id_project_seq OWNED BY public.projects.id_project;
          public          postgres    false    216            ?            1259    16489    timesheet_detail    TABLE     ?   CREATE TABLE public.timesheet_detail (
    timesheet_project_id integer NOT NULL,
    monday integer,
    tuesday integer,
    wednesday integer,
    thursday integer,
    friday integer,
    saturday integer,
    sunday integer
);
 $   DROP TABLE public.timesheet_detail;
       public         heap    postgres    false            ?            1259    16431    timesheet_employees    TABLE     _   CREATE TABLE public.timesheet_employees (
    id_employee integer,
    id_timesheet integer
);
 '   DROP TABLE public.timesheet_employees;
       public         heap    postgres    false            ?            1259    16445    timesheet_project    TABLE     ?   CREATE TABLE public.timesheet_project (
    timesheet_project_id integer NOT NULL,
    timesheet_id integer,
    proyect_id integer,
    timesheet_status_id integer,
    comment text,
    attachment text,
    total_hours integer
);
 %   DROP TABLE public.timesheet_project;
       public         heap    postgres    false            ?            1259    16444 *   timesheet_project_timesheet_project_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.timesheet_project_timesheet_project_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.timesheet_project_timesheet_project_id_seq;
       public          postgres    false    215            :           0    0 *   timesheet_project_timesheet_project_id_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.timesheet_project_timesheet_project_id_seq OWNED BY public.timesheet_project.timesheet_project_id;
          public          postgres    false    214            ?            1259    16477    timesheet_status    TABLE     \   CREATE TABLE public.timesheet_status (
    id integer NOT NULL,
    status text NOT NULL
);
 $   DROP TABLE public.timesheet_status;
       public         heap    postgres    false            |           2604    16419    Employees Id    DEFAULT     r   ALTER TABLE ONLY public."Employees" ALTER COLUMN "Id" SET DEFAULT nextval('public."Employees_Id_seq"'::regclass);
 ?   ALTER TABLE public."Employees" ALTER COLUMN "Id" DROP DEFAULT;
       public          postgres    false    209    210    210                       2604    16462    projects id_project    DEFAULT     z   ALTER TABLE ONLY public.projects ALTER COLUMN id_project SET DEFAULT nextval('public.projects_id_project_seq'::regclass);
 B   ALTER TABLE public.projects ALTER COLUMN id_project DROP DEFAULT;
       public          postgres    false    217    216    217            }           2604    16428    timesheet id_timesheet    DEFAULT     ?   ALTER TABLE ONLY public.timesheet ALTER COLUMN id_timesheet SET DEFAULT nextval('public."Timesheet_id_timesheet_seq"'::regclass);
 E   ALTER TABLE public.timesheet ALTER COLUMN id_timesheet DROP DEFAULT;
       public          postgres    false    211    212    212            ~           2604    16448 &   timesheet_project timesheet_project_id    DEFAULT     ?   ALTER TABLE ONLY public.timesheet_project ALTER COLUMN timesheet_project_id SET DEFAULT nextval('public.timesheet_project_timesheet_project_id_seq'::regclass);
 U   ALTER TABLE public.timesheet_project ALTER COLUMN timesheet_project_id DROP DEFAULT;
       public          postgres    false    215    214    215            %          0    16416 	   Employees 
   TABLE DATA           F   COPY public."Employees" ("Id", "Name", "Rol", "Password") FROM stdin;
    public          postgres    false    210   ^F       0          0    16508    Manager 
   TABLE DATA           ?   COPY public."Manager" ("Emplyee_Id", "Manager_Id") FROM stdin;
    public          postgres    false    221   ?F       ,          0    16459    projects 
   TABLE DATA           A   COPY public.projects (id_project, name, id_employee) FROM stdin;
    public          postgres    false    217   ?F       '          0    16425 	   timesheet 
   TABLE DATA           `   COPY public.timesheet (id_timesheet, start_date, end_date, id_manager, id_employee) FROM stdin;
    public          postgres    false    212   G       .          0    16489    timesheet_detail 
   TABLE DATA           ?   COPY public.timesheet_detail (timesheet_project_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday) FROM stdin;
    public          postgres    false    219   XG       (          0    16431    timesheet_employees 
   TABLE DATA           H   COPY public.timesheet_employees (id_employee, id_timesheet) FROM stdin;
    public          postgres    false    213   ?G       *          0    16445    timesheet_project 
   TABLE DATA           ?   COPY public.timesheet_project (timesheet_project_id, timesheet_id, proyect_id, timesheet_status_id, comment, attachment, total_hours) FROM stdin;
    public          postgres    false    215   ?G       -          0    16477    timesheet_status 
   TABLE DATA           6   COPY public.timesheet_status (id, status) FROM stdin;
    public          postgres    false    218   *H       ;           0    0    Employees_Id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."Employees_Id_seq"', 3, true);
          public          postgres    false    209            <           0    0    Timesheet_id_timesheet_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Timesheet_id_timesheet_seq"', 3, true);
          public          postgres    false    211            =           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 15, true);
          public          postgres    false    220            >           0    0    projects_id_project_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.projects_id_project_seq', 1, false);
          public          postgres    false    216            ?           0    0 *   timesheet_project_timesheet_project_id_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.timesheet_project_timesheet_project_id_seq', 7, true);
          public          postgres    false    214            ?           2606    16423    Employees Employees_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Employees"
    ADD CONSTRAINT "Employees_pkey" PRIMARY KEY ("Id");
 F   ALTER TABLE ONLY public."Employees" DROP CONSTRAINT "Employees_pkey";
       public            postgres    false    210            ?           2606    16512    Manager Manager_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Manager"
    ADD CONSTRAINT "Manager_pkey" PRIMARY KEY ("Emplyee_Id");
 B   ALTER TABLE ONLY public."Manager" DROP CONSTRAINT "Manager_pkey";
       public            postgres    false    221            ?           2606    16430    timesheet Timesheet_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT "Timesheet_pkey" PRIMARY KEY (id_timesheet);
 D   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT "Timesheet_pkey";
       public            postgres    false    212            ?           2606    16466    projects projects_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id_project);
 @   ALTER TABLE ONLY public.projects DROP CONSTRAINT projects_pkey;
       public            postgres    false    217            ?           2606    16531 &   timesheet_detail timesheet_detail_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.timesheet_detail
    ADD CONSTRAINT timesheet_detail_pkey PRIMARY KEY (timesheet_project_id);
 P   ALTER TABLE ONLY public.timesheet_detail DROP CONSTRAINT timesheet_detail_pkey;
       public            postgres    false    219            ?           2606    16452 (   timesheet_project timesheet_project_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_pkey PRIMARY KEY (timesheet_project_id);
 R   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_pkey;
       public            postgres    false    215            ?           2606    16483 &   timesheet_status timesheet_status_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.timesheet_status
    ADD CONSTRAINT timesheet_status_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.timesheet_status DROP CONSTRAINT timesheet_status_pkey;
       public            postgres    false    218            ?           2606    16513    Manager Manager_Emplyee_Id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."Manager"
    ADD CONSTRAINT "Manager_Emplyee_Id_fkey" FOREIGN KEY ("Emplyee_Id") REFERENCES public."Employees"("Id");
 M   ALTER TABLE ONLY public."Manager" DROP CONSTRAINT "Manager_Emplyee_Id_fkey";
       public          postgres    false    221    3201    210            ?           2606    16518    Manager Manager_Manager_Id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."Manager"
    ADD CONSTRAINT "Manager_Manager_Id_fkey" FOREIGN KEY ("Manager_Id") REFERENCES public."Employees"("Id") NOT VALID;
 M   ALTER TABLE ONLY public."Manager" DROP CONSTRAINT "Manager_Manager_Id_fkey";
       public          postgres    false    221    210    3201            ?           2606    16467 "   projects projects_id_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_id_employee_fkey FOREIGN KEY (id_employee) REFERENCES public."Employees"("Id");
 L   ALTER TABLE ONLY public.projects DROP CONSTRAINT projects_id_employee_fkey;
       public          postgres    false    217    3201    210            ?           2606    16492 ;   timesheet_detail timesheet_detail_timesheet_project_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_detail
    ADD CONSTRAINT timesheet_detail_timesheet_project_id_fkey FOREIGN KEY (timesheet_project_id) REFERENCES public.timesheet_project(timesheet_project_id);
 e   ALTER TABLE ONLY public.timesheet_detail DROP CONSTRAINT timesheet_detail_timesheet_project_id_fkey;
       public          postgres    false    215    219    3205            ?           2606    16434 8   timesheet_employees timesheet_employees_id_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_employees
    ADD CONSTRAINT timesheet_employees_id_employee_fkey FOREIGN KEY (id_employee) REFERENCES public."Employees"("Id") NOT VALID;
 b   ALTER TABLE ONLY public.timesheet_employees DROP CONSTRAINT timesheet_employees_id_employee_fkey;
       public          postgres    false    210    3201    213            ?           2606    16439 9   timesheet_employees timesheet_employees_id_timesheet_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_employees
    ADD CONSTRAINT timesheet_employees_id_timesheet_fkey FOREIGN KEY (id_timesheet) REFERENCES public.timesheet(id_timesheet) NOT VALID;
 c   ALTER TABLE ONLY public.timesheet_employees DROP CONSTRAINT timesheet_employees_id_timesheet_fkey;
       public          postgres    false    213    212    3203            ?           2606    16503 $   timesheet timesheet_id_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT timesheet_id_employee_fkey FOREIGN KEY (id_employee) REFERENCES public."Employees"("Id") NOT VALID;
 N   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT timesheet_id_employee_fkey;
       public          postgres    false    3201    210    212            ?           2606    16498 #   timesheet timesheet_id_manager_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT timesheet_id_manager_fkey FOREIGN KEY (id_manager) REFERENCES public."Employees"("Id") NOT VALID;
 M   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT timesheet_id_manager_fkey;
       public          postgres    false    212    210    3201            ?           2606    16472 3   timesheet_project timesheet_project_proyect_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_proyect_id_fkey FOREIGN KEY (proyect_id) REFERENCES public.projects(id_project) NOT VALID;
 ]   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_proyect_id_fkey;
       public          postgres    false    3207    215    217            ?           2606    16453 5   timesheet_project timesheet_project_timesheet_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_timesheet_id_fkey FOREIGN KEY (timesheet_id) REFERENCES public.timesheet(id_timesheet) NOT VALID;
 _   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_timesheet_id_fkey;
       public          postgres    false    3203    215    212            ?           2606    16484 <   timesheet_project timesheet_project_timesheet_status_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_timesheet_status_id_fkey FOREIGN KEY (timesheet_status_id) REFERENCES public.timesheet_status(id) NOT VALID;
 f   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_timesheet_status_id_fkey;
       public          postgres    false    215    218    3209            %   E   x?3?tϯ??t????tu?,H,..?/J?2?tt?????u?stwBHs??a?b?b??'F??? ??%      0      x?3?4?2?4?????? ??      ,      x?3?,(*MMJ?4?2B0c???? h??      '   F   x?M???@D?3??a⮽?Fb????:aNCv҅?,?????0?????DHJ??C?U?>T????      .   :   x?3?4BcNSNsNN.# ??7?24 2?8???H(??A?CS4?=... ?.
?      (      x?3?4?????? ]      *   W   x?3?4?4??ĔD?D0?44?24 ?r??&%?(?X??L??9????i??)?	X* ,??T??ѨW???id????? ?S!       -   .   x?3?H?K?L?+I?2?t,(?/KL??2?tI-N??@?=... K?     