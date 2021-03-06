PGDMP     4                    z            FinalProject    14.2    14.2 D    C           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            D           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            E           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            F           1262    16394    FinalProject    DATABASE     k   CREATE DATABASE "FinalProject" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE "FinalProject";
                postgres    false            ?            1259    16416    users    TABLE     ?   CREATE TABLE public.users (
    "Id" integer NOT NULL,
    "User" text NOT NULL,
    "Rol" text NOT NULL,
    "Password" text NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    16415    Employees_Id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Employees_Id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."Employees_Id_seq";
       public          postgres    false    210            G           0    0    Employees_Id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public."Employees_Id_seq" OWNED BY public.users."Id";
          public          postgres    false    209            ?            1259    16611    employee_manager    TABLE     g   CREATE TABLE public.employee_manager (
    id integer NOT NULL,
    manager text,
    employee text
);
 $   DROP TABLE public.employee_manager;
       public         heap    postgres    false            ?            1259    16610    Manager_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Manager_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Manager_id_seq";
       public          postgres    false    224            H           0    0    Manager_id_seq    SEQUENCE OWNED BY     L   ALTER SEQUENCE public."Manager_id_seq" OWNED BY public.employee_manager.id;
          public          postgres    false    223            ?            1259    16425 	   timesheet    TABLE     ?   CREATE TABLE public.timesheet (
    id_timesheet integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    user_manager text,
    user_employee text
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
       public          postgres    false    212            I           0    0    Timesheet_id_timesheet_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."Timesheet_id_timesheet_seq" OWNED BY public.timesheet.id_timesheet;
          public          postgres    false    211            ?            1259    16497    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16582    manager    TABLE     ?   CREATE TABLE public.manager (
    user_employee integer NOT NULL,
    user_manager character varying(255),
    id integer NOT NULL
);
    DROP TABLE public.manager;
       public         heap    postgres    false            ?            1259    16581    manager_user_employee_seq    SEQUENCE     ?   CREATE SEQUENCE public.manager_user_employee_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.manager_user_employee_seq;
       public          postgres    false    222            J           0    0    manager_user_employee_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.manager_user_employee_seq OWNED BY public.manager.user_employee;
          public          postgres    false    221            ?            1259    16459    projects    TABLE     d   CREATE TABLE public.projects (
    id_project integer NOT NULL,
    name text,
    employee text
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
       public          postgres    false    217            K           0    0    projects_id_project_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.projects_id_project_seq OWNED BY public.projects.id_project;
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
       public          postgres    false    215            L           0    0 *   timesheet_project_timesheet_project_id_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.timesheet_project_timesheet_project_id_seq OWNED BY public.timesheet_project.timesheet_project_id;
          public          postgres    false    214            ?            1259    16477    timesheet_status    TABLE     \   CREATE TABLE public.timesheet_status (
    id integer NOT NULL,
    status text NOT NULL
);
 $   DROP TABLE public.timesheet_status;
       public         heap    postgres    false            ?           2604    16614    employee_manager id    DEFAULT     s   ALTER TABLE ONLY public.employee_manager ALTER COLUMN id SET DEFAULT nextval('public."Manager_id_seq"'::regclass);
 B   ALTER TABLE public.employee_manager ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            ?           2604    16585    manager user_employee    DEFAULT     ~   ALTER TABLE ONLY public.manager ALTER COLUMN user_employee SET DEFAULT nextval('public.manager_user_employee_seq'::regclass);
 D   ALTER TABLE public.manager ALTER COLUMN user_employee DROP DEFAULT;
       public          postgres    false    221    222    222            ?           2604    16462    projects id_project    DEFAULT     z   ALTER TABLE ONLY public.projects ALTER COLUMN id_project SET DEFAULT nextval('public.projects_id_project_seq'::regclass);
 B   ALTER TABLE public.projects ALTER COLUMN id_project DROP DEFAULT;
       public          postgres    false    217    216    217            ?           2604    16428    timesheet id_timesheet    DEFAULT     ?   ALTER TABLE ONLY public.timesheet ALTER COLUMN id_timesheet SET DEFAULT nextval('public."Timesheet_id_timesheet_seq"'::regclass);
 E   ALTER TABLE public.timesheet ALTER COLUMN id_timesheet DROP DEFAULT;
       public          postgres    false    212    211    212            ?           2604    16448 &   timesheet_project timesheet_project_id    DEFAULT     ?   ALTER TABLE ONLY public.timesheet_project ALTER COLUMN timesheet_project_id SET DEFAULT nextval('public.timesheet_project_timesheet_project_id_seq'::regclass);
 U   ALTER TABLE public.timesheet_project ALTER COLUMN timesheet_project_id DROP DEFAULT;
       public          postgres    false    215    214    215            ?           2604    16419    users Id    DEFAULT     l   ALTER TABLE ONLY public.users ALTER COLUMN "Id" SET DEFAULT nextval('public."Employees_Id_seq"'::regclass);
 9   ALTER TABLE public.users ALTER COLUMN "Id" DROP DEFAULT;
       public          postgres    false    209    210    210            @          0    16611    employee_manager 
   TABLE DATA           A   COPY public.employee_manager (id, manager, employee) FROM stdin;
    public          postgres    false    224   ?S       >          0    16582    manager 
   TABLE DATA           B   COPY public.manager (user_employee, user_manager, id) FROM stdin;
    public          postgres    false    222   ?S       9          0    16459    projects 
   TABLE DATA           >   COPY public.projects (id_project, name, employee) FROM stdin;
    public          postgres    false    217   ?S       4          0    16425 	   timesheet 
   TABLE DATA           d   COPY public.timesheet (id_timesheet, start_date, end_date, user_manager, user_employee) FROM stdin;
    public          postgres    false    212   1T       ;          0    16489    timesheet_detail 
   TABLE DATA           ?   COPY public.timesheet_detail (timesheet_project_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday) FROM stdin;
    public          postgres    false    219   ?T       5          0    16431    timesheet_employees 
   TABLE DATA           H   COPY public.timesheet_employees (id_employee, id_timesheet) FROM stdin;
    public          postgres    false    213   ?T       7          0    16445    timesheet_project 
   TABLE DATA           ?   COPY public.timesheet_project (timesheet_project_id, timesheet_id, proyect_id, timesheet_status_id, comment, attachment, total_hours) FROM stdin;
    public          postgres    false    215   U       :          0    16477    timesheet_status 
   TABLE DATA           6   COPY public.timesheet_status (id, status) FROM stdin;
    public          postgres    false    218   ?U       2          0    16416    users 
   TABLE DATA           @   COPY public.users ("Id", "User", "Rol", "Password") FROM stdin;
    public          postgres    false    210   ?U       M           0    0    Employees_Id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."Employees_Id_seq"', 3, true);
          public          postgres    false    209            N           0    0    Manager_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Manager_id_seq"', 2, true);
          public          postgres    false    223            O           0    0    Timesheet_id_timesheet_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Timesheet_id_timesheet_seq"', 3, true);
          public          postgres    false    211            P           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 22, true);
          public          postgres    false    220            Q           0    0    manager_user_employee_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.manager_user_employee_seq', 1, false);
          public          postgres    false    221            R           0    0    projects_id_project_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.projects_id_project_seq', 1, false);
          public          postgres    false    216            S           0    0 *   timesheet_project_timesheet_project_id_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.timesheet_project_timesheet_project_id_seq', 7, true);
          public          postgres    false    214            ?           2606    16423    users Employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "Employees_pkey" PRIMARY KEY ("Id");
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT "Employees_pkey";
       public            postgres    false    210            ?           2606    16618    employee_manager Manager_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.employee_manager
    ADD CONSTRAINT "Manager_pkey" PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.employee_manager DROP CONSTRAINT "Manager_pkey";
       public            postgres    false    224            ?           2606    16430    timesheet Timesheet_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT "Timesheet_pkey" PRIMARY KEY (id_timesheet);
 D   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT "Timesheet_pkey";
       public            postgres    false    212            ?           2606    16620 .   employee_manager employee_manager_employee_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.employee_manager
    ADD CONSTRAINT employee_manager_employee_key UNIQUE (employee);
 X   ALTER TABLE ONLY public.employee_manager DROP CONSTRAINT employee_manager_employee_key;
       public            postgres    false    224            ?           2606    16587    manager manager_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.manager
    ADD CONSTRAINT manager_pkey PRIMARY KEY (user_employee);
 >   ALTER TABLE ONLY public.manager DROP CONSTRAINT manager_pkey;
       public            postgres    false    222            ?           2606    16466    projects projects_pkey 
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
       public            postgres    false    218            ?           2606    16547    users users_User_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "users_User_key" UNIQUE ("User");
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT "users_User_key";
       public            postgres    false    210            ?           2606    16626 /   employee_manager employee_manager_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee_manager
    ADD CONSTRAINT employee_manager_employee_fkey FOREIGN KEY (employee) REFERENCES public.users("User") NOT VALID;
 Y   ALTER TABLE ONLY public.employee_manager DROP CONSTRAINT employee_manager_employee_fkey;
       public          postgres    false    3211    224    210            ?           2606    16621 .   employee_manager employee_manager_manager_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee_manager
    ADD CONSTRAINT employee_manager_manager_fkey FOREIGN KEY (manager) REFERENCES public.users("User") NOT VALID;
 X   ALTER TABLE ONLY public.employee_manager DROP CONSTRAINT employee_manager_manager_fkey;
       public          postgres    false    3211    210    224            ?           2606    16492 ;   timesheet_detail timesheet_detail_timesheet_project_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_detail
    ADD CONSTRAINT timesheet_detail_timesheet_project_id_fkey FOREIGN KEY (timesheet_project_id) REFERENCES public.timesheet_project(timesheet_project_id);
 e   ALTER TABLE ONLY public.timesheet_detail DROP CONSTRAINT timesheet_detail_timesheet_project_id_fkey;
       public          postgres    false    215    219    3215            ?           2606    16434 8   timesheet_employees timesheet_employees_id_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_employees
    ADD CONSTRAINT timesheet_employees_id_employee_fkey FOREIGN KEY (id_employee) REFERENCES public.users("Id") NOT VALID;
 b   ALTER TABLE ONLY public.timesheet_employees DROP CONSTRAINT timesheet_employees_id_employee_fkey;
       public          postgres    false    210    3209    213            ?           2606    16439 9   timesheet_employees timesheet_employees_id_timesheet_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_employees
    ADD CONSTRAINT timesheet_employees_id_timesheet_fkey FOREIGN KEY (id_timesheet) REFERENCES public.timesheet(id_timesheet) NOT VALID;
 c   ALTER TABLE ONLY public.timesheet_employees DROP CONSTRAINT timesheet_employees_id_timesheet_fkey;
       public          postgres    false    3213    213    212            ?           2606    16472 3   timesheet_project timesheet_project_proyect_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_proyect_id_fkey FOREIGN KEY (proyect_id) REFERENCES public.projects(id_project) NOT VALID;
 ]   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_proyect_id_fkey;
       public          postgres    false    215    3217    217            ?           2606    16453 5   timesheet_project timesheet_project_timesheet_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_timesheet_id_fkey FOREIGN KEY (timesheet_id) REFERENCES public.timesheet(id_timesheet) NOT VALID;
 _   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_timesheet_id_fkey;
       public          postgres    false    3213    215    212            ?           2606    16484 <   timesheet_project timesheet_project_timesheet_status_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet_project
    ADD CONSTRAINT timesheet_project_timesheet_status_id_fkey FOREIGN KEY (timesheet_status_id) REFERENCES public.timesheet_status(id) NOT VALID;
 f   ALTER TABLE ONLY public.timesheet_project DROP CONSTRAINT timesheet_project_timesheet_status_id_fkey;
       public          postgres    false    218    215    3219            ?           2606    16555 &   timesheet timesheet_user_employee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT timesheet_user_employee_fkey FOREIGN KEY (user_employee) REFERENCES public.users("User") NOT VALID;
 P   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT timesheet_user_employee_fkey;
       public          postgres    false    210    212    3211            ?           2606    16550 %   timesheet timesheet_user_manager_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.timesheet
    ADD CONSTRAINT timesheet_user_manager_fkey FOREIGN KEY (user_manager) REFERENCES public.users("User") NOT VALID;
 O   ALTER TABLE ONLY public.timesheet DROP CONSTRAINT timesheet_user_manager_fkey;
       public          postgres    false    210    3211    212            @   '   x?3??M?KLO-?L?-?ɯLM?2?	?Ō?b???? Z!      >      x?????? ? ?      9   $   x?3?,(*MMJ?L?-?ɯLM?2B1?????? /?4      4   q   x????
? E?ο?(>??Mi????0??pw???EA?P*?h*?iٗ5^"?s;?A?????R?^?5c?E?Fdt?H`??k?{m????o??7?Q?pi5?	 ??_?      ;   :   x?3?4BcNSNsNN.# ??7?24 2?8???H(??A?CS4?=... ?.
?      5      x?3?4?????? ]      7   W   x?3?4?4??ĔD?D0?44?24 ?r??&%?(?X??L??9????i??)?	X* ,??T??ѨW???id????? ?S!       :   .   x?3?H?K?L?+I?2?t,(?/KL??2?tI-N??@?=... K?      2   I   x?3?L?-?ɯLM?t????tu?,H,..?/J?2??M?KLO-??u?stwBH??a?h?h??3F??? ?t%c     